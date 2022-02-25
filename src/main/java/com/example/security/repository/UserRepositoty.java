package com.example.security.repository;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.security.entity.UserEntity;

public interface UserRepositoty extends JpaRepository<UserEntity, Long> {
	@Query("SELECT u from UserEntity u where u.id = :id")
	UserEntity findByUserId(@Param("id")String id);
}
