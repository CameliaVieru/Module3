package com.example.curshibernate2xml.repos;

import com.example.curshibernate2xml.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
