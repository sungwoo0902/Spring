package kr.co.ch12.oauth2;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import kr.co.ch12.entity.UserEntity;
import kr.co.ch12.repository.UserRepository;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class OAuth2UserService extends DefaultOAuth2UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {

		// 인증 서버에서 클라이언트에게 엑세스 토큰으로 발급 및 인증
		String accessToken = userRequest.getAccessToken().getTokenValue();
		log.info("OAuth2UserService...1 : " +accessToken);
		
		String provider = userRequest.getClientRegistration().getRegistrationId();
		log.info("OAuth2UserService...2 : " + provider);
		
		OAuth2User oAuth2User = super.loadUser(userRequest);
		log.info("OAuth2UserService...3 : " + oAuth2User);
		
		Map<String, Object> attributes = oAuth2User.getAttributes();
		
		KakaoInfo kakaoInfo = new KakaoInfo(attributes);
		log.info("OAuth2UserService...4 : " + kakaoInfo);
		
		// 회원가입 처리
		// 카카오는 가입 이메일을 ID로 사용하기 때문에 여기서 id는 단순한 식별번호이다.
		String id = kakaoInfo.getId();
		String email = kakaoInfo.getEmail();
		String nickname = kakaoInfo.getNickName();
		
		Optional<UserEntity> result = userRepository.findById(id);
		
		UserEntity user = null;
		
		if(result.isEmpty()) {
			// 최초 소셜 로그인 동의체크 후 가입
			user = UserEntity.builder()
										.uid(provider+"_"+id)
										.name(nickname)
										.nickname(nickname)
										.email(email)
										.provider(provider)
										.role("USER")
										.build();
			
			userRepository.save(user);
			
		}else {
			// 회원가입된 사용자 조회
			user = result.get();
		}
		
		return user;
	}
}
