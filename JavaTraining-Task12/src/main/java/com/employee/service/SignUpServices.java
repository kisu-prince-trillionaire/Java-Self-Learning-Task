package com.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.bean.UserSignUp;
import com.employee.dao.SignUpRepository;

@Service
public class SignUpServices {
	@Autowired
	private SignUpRepository signUpRepo;
	
	public UserSignUp saveUser(UserSignUp user) {
		UserSignUp result = signUpRepo.save(user);
		return result;
	}
	
	public UserSignUp getUserByEmail(String email) {
		UserSignUp result = signUpRepo.findByEmail(email);
		return result;
	}
}
