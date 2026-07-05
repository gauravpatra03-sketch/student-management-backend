package com.student.management.service;

import java.util.List;

import com.student.management.dto.CourseStatistics;
import com.student.management.dto.DashboardResponse;

public interface DashboardService {

    DashboardResponse getDashboardData();
    
    List<CourseStatistics> getCourseStatistics();

}