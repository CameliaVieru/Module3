package com.example.curshibernate2xml.repos;

import com.example.curshibernate2xml.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer> {
}
