package com.example.curshibernate2xml.dtos.response;

import com.example.curshibernate2xml.model.Course;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@Data
@AllArgsConstructor
public class TeacherSuccessResponseDTO {
    private long id;
    private String name;
    private Set<Course> courses;
}
