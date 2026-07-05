package com.student.management.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.student.management.dto.LoginRequest;
import com.student.management.dto.LoginResponse;
import com.student.management.entity.Login;
import com.student.management.repository.LoginRepository;
import com.student.management.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginRepository loginRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        Optional<Login> login = loginRepository.findByUsername(loginRequest.getUsername());

        if (login.isPresent()) {
            // Compare hashed password
            if (passwordEncoder.matches(loginRequest.getPassword(), login.get().getPassword())) {
                return new LoginResponse(true, "Login Successful");
            }
        }

        return new LoginResponse(false, "Invalid Username or Password");
    }

    @Override
    public Login register(Login login) {
        // Check for duplicate username
        Optional<Login> existingUser = loginRepository.findByUsername(login.getUsername());
        if (existingUser.isPresent()) {
            throw new RuntimeException("Username already exists");
        }
        
        // Hash the password before saving
        login.setPassword(passwordEncoder.encode(login.getPassword()));
        return loginRepository.save(login);
    }
}