package com.example.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.security.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	@Query("SELECT u FROM User u WHERE u.id = :username")
	public User loadUserByUsername(@Param("username")String username);
}
