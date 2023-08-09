package com.example.test.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
public class SecurityController {
	
	@GetMapping("/")
	public String index(HttpServletRequest request, HttpSession session) {
		
		return "hi";
	}// index
	
	@GetMapping("/user")
	public String user() {
		return "user";
	}// user
	
}// SecurityController
