package com.example.bookstoreapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookstoreapi.security.JwtUtil;

@RestController
public class AuthController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@PostMapping("/authenticate")
	public String createAuthenticationToken(@RequestParam String username, @RequestParam String password) throws Exception{
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		
		final String jwt = jwtUtil.generateToken(username);
		
		return jwt;
	}
	
}
