package com.student.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.student.management.dto.DashboardResponse;
import com.student.management.service.DashboardService;

import io.swagger.v3.oas.annotations.Operation;

import java.util.List;
import com.student.management.dto.CourseStatistics;

@RestController
@RequestMapping("/dashboard")
@CrossOrigin(origins = "http://localhost:4200")
public class DashboardController {

    @Autowired
    private DashboardService dashboardService;

    @Operation(summary = "Dashboard Data")
    @GetMapping
    public DashboardResponse getDashboardData() {

        return dashboardService.getDashboardData();

    }
    
    @GetMapping("/courses")
    public List<CourseStatistics> getCourseStatistics(){

        return dashboardService.getCourseStatistics();

    }

}