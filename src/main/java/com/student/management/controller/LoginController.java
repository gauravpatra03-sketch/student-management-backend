package com.student.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.student.management.dto.LoginRequest;
import com.student.management.dto.LoginResponse;
import com.student.management.dto.RegisterResponse;
import com.student.management.entity.Login;
import com.student.management.service.LoginService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:4201"})
public class LoginController {

	@Autowired
	private LoginService loginService;

	@Operation(summary = "Register User")
	@PostMapping("/register")
	public ResponseEntity<?> register(@Valid @RequestBody Login login) {
	    try {
	        loginService.register(login);
	        return ResponseEntity.ok(new LoginResponse(true, "Registration Successful"));
	    } catch (RuntimeException e) {
	        return ResponseEntity.badRequest().body(new LoginResponse(false, e.getMessage()));
	    }
	}

	@Operation(summary = "Login")
	@PostMapping("/login")
	public LoginResponse login(@Valid @RequestBody LoginRequest loginRequest) {

		return loginService.login(loginRequest);

	}
	
	

}