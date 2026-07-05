package com.student.management.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.management.entity.Login;

public interface LoginRepository extends JpaRepository<Login, Integer> {

    Optional<Login> findByUsername(String username);

}