package kr.ch11.controller;

import java.util.Map;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import kr.ch11.dto.UserRequestDTO;
import kr.ch11.entity.UserEntity;
import kr.ch11.jwt.JwtProvider;
import kr.ch11.security.MyUserDetails;
import lombok.RequiredArgsConstructor;

// 생성자 방식으로 주입(@Autowired 중복 선언 대체 가능)
@RequiredArgsConstructor
// 화면 출력이 아닌 데이터를 출력하는 컨트롤러
@RestController
@Log4j2
public class UserController {

	private final AuthenticationManager authenticationManager;
	private final JwtProvider jwtProvider;

	@CrossOrigin("*")
	@PostMapping("/login")
	public Map<String, String> login(@RequestBody UserRequestDTO dto) {
		
		try {

			log.info("dto : " + dto);

			// Security 인증처리
			UsernamePasswordAuthenticationToken authenticationToken
				= new UsernamePasswordAuthenticationToken(dto.getUid(), dto.getPass());
			
			Authentication authentication = authenticationManager.authenticate(authenticationToken);
			MyUserDetails userDetails = (MyUserDetails) authentication.getPrincipal();
			
			UserEntity user= userDetails.getUser();
			
			// 토큰발행
			String accessToken = jwtProvider.createToken(user, 1);	// 1일
			String refreshToken = jwtProvider.createToken(user, 7);	// 7일
			
			Map<String, String> resultMap = Map.of("grantType", "Bearer",
												   "accessToken", accessToken,
												   "refreshToken", refreshToken);
					
			return resultMap;
			
		} catch (Exception e) {
			Map<String, String> resultMap = Map.of("grantType", "None",
					   							   "message", e.getMessage());
			return resultMap;
		}
	}
}
