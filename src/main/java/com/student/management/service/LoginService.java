package com.student.management.service;

import com.student.management.dto.LoginRequest;
import com.student.management.dto.LoginResponse;
import com.student.management.entity.Login;

public interface LoginService {
	
	Login register(Login login);

    LoginResponse login(LoginRequest loginRequest);

}