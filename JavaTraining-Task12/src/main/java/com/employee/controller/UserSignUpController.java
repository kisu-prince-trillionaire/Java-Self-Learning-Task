package com.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.employee.bean.UserSignUp;
import com.employee.service.SignUpServices;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class UserSignUpController {
	@Autowired
	private SignUpServices service;

	@GetMapping("/signUp")
	public String getSignUp(Model model) {
		System.out.println("In signup page");
		model.addAttribute("userSignUp", new UserSignUp());
		return "signUp";
	}

	@PostMapping("/register")
	public String processRegister(UserSignUp userSignUp, HttpServletRequest request) {
		String email = request.getParameter("email");
		UserSignUp user  = service.getUserByEmail(email);
		if(user == null) {
			service.saveUser(userSignUp);

			return "sucess";
		}
		return "error";
	}
	
	@GetMapping("/login")
	public String getLogin() {
		System.out.println("In Login page");
		return "login";
	}
}
