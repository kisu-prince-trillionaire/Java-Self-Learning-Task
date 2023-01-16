package com.employee.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.employee.bean.UserSignUp;

@Repository
public interface SignUpRepository extends JpaRepository<UserSignUp, String> {
	@Query("SELECT u FROM UserSignUp u WHERE u.email = ?1")
	public UserSignUp findByEmail(@Param("email") String email);
	
	@Query("UPDATE Sneakers s SET name = ?1 WHERE shoe_id = ?2 ")

}
