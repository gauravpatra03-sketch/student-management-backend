package com.student.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.student.management.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	List<Student> findByNameContainingIgnoreCase(String name);

	long countByGenderIgnoreCase(String gender);

	@Query("SELECT COUNT(DISTINCT s.course) FROM Student s")
	long countDistinctCourses();

	@Query("""
			SELECT s.course, COUNT(s)
			FROM Student s
			GROUP BY s.course
			""")
	List<Object[]> getCourseStatistics();
}