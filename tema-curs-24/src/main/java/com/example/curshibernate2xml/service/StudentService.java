package com.example.curshibernate2xml.service;

import com.example.curshibernate2xml.dtos.request.JoinCourseRequestDTO;
import com.example.curshibernate2xml.dtos.response.CourseResponseDTO;
import com.example.curshibernate2xml.dtos.response.JoinCourseResponseDTO;
import com.example.curshibernate2xml.model.Course;
import com.example.curshibernate2xml.model.Student;
import com.example.curshibernate2xml.model.StudentToCourse;
import com.example.curshibernate2xml.repos.CourseRepository;
import com.example.curshibernate2xml.repos.StudentRepository;
import com.example.curshibernate2xml.repos.StudentToCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final StudentToCourseRepository studentToCourseRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository, CourseRepository courseRepository, StudentToCourseRepository studentToCourseRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
        this.studentToCourseRepository = studentToCourseRepository;
    }

    public ResponseEntity<JoinCourseResponseDTO> joinCourse(JoinCourseRequestDTO joinCourseRequestDTO) {
        Student student = studentRepository.getById(joinCourseRequestDTO.getStudentId());
        Course course = courseRepository.getById(joinCourseRequestDTO.getCourseId());
        StudentToCourse studentToCourse = new StudentToCourse();
        studentToCourse.setStudent(student);
        studentToCourse.setCourse(course);
        studentToCourseRepository.save(studentToCourse);

        return new ResponseEntity<>(new JoinCourseResponseDTO(studentToCourse.getId(), studentToCourse.getStudent().getId(), studentToCourse.getCourse().getId()), HttpStatus.CREATED);
    }

    public ResponseEntity<Set<CourseResponseDTO>> getCourses(Integer studentId) {
        Student student = studentRepository.getById(studentId);
        Set<Course> courseSet = student.getChosenCourses();
        Set<CourseResponseDTO> courseResponseDTOset = new HashSet<>();
        for (Course course : courseSet) {
            courseResponseDTOset.add(new CourseResponseDTO(course.getId(), course.getName(), course.getTeacher().getId()));
        }

        return new ResponseEntity<>(courseResponseDTOset, HttpStatus.ACCEPTED);
    }
}
