package com.student.management.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.student.management.entity.Login;
import com.student.management.repository.LoginRepository;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private LoginRepository loginRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        if (loginRepository.findByUsername("admin").isEmpty()) {
            Login admin = new Login();
            admin.setUsername("admin");
            admin.setPassword(passwordEncoder.encode("admin123"));
            loginRepository.save(admin);
            System.out.println("Default admin user created: admin/admin123");
        }
    }
}