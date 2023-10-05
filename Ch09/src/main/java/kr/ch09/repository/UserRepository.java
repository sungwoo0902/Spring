package kr.ch09.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.ch09.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String>{
	
	// 아이디 비밀번호를 조회하는 쿼리 메서드
	public UserEntity findUserEntityByUidAndPass(String uid, String pass);

}
