package com.example.curshibernate2xml.dtos.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class JoinCourseRequestDTO {
    @NotNull(message = "student.id.must.not.be.null")
    private Integer studentId;
    @NotNull(message = "course.id.must.not.be.null")
    private Integer courseId;
}
