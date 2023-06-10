package com.example.curshibernate2xml.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CourseResponseDTO {

    private Integer id;
    private String name;
    private Integer teacherId;
}
