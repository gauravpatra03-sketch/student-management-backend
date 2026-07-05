package com.student.management.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.management.dto.CourseStatistics;
import com.student.management.dto.DashboardResponse;
import com.student.management.repository.StudentRepository;
import com.student.management.service.DashboardService;

@Service
public class DashboardServiceImpl implements DashboardService {

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public DashboardResponse getDashboardData() {

		long totalStudents = studentRepository.count();

		long totalCourses = studentRepository.countDistinctCourses();

		long totalMale = studentRepository.countByGenderIgnoreCase("Male");

		long totalFemale = studentRepository.countByGenderIgnoreCase("Female");

		return new DashboardResponse(totalStudents, totalCourses, totalMale, totalFemale);

	}

	@Override
	public List<CourseStatistics> getCourseStatistics() {

		List<Object[]> result = studentRepository.getCourseStatistics();

		List<CourseStatistics> statistics = new ArrayList<>();

		for (Object[] row : result) {

			String course = (String) row[0];

			Long total = (Long) row[1];

			statistics.add(new CourseStatistics(course, total));

		}

		return statistics;

	}

}