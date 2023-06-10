package com.example.curshibernate2xml.repos;

import com.example.curshibernate2xml.model.StudentToCourse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentToCourseRepository extends JpaRepository<StudentToCourse, Integer> {
}
