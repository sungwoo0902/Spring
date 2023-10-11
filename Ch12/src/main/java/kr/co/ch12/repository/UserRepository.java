package kr.co.ch12.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.co.ch12.entity.UserEntity;


public interface UserRepository extends JpaRepository<UserEntity, String> {

}
