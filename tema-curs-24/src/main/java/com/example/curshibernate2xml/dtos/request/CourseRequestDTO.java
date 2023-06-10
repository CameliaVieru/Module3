package com.example.curshibernate2xml.dtos.request;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class CourseRequestDTO {

    @NotEmpty(message = "course.name.must.not.be.null.or.empty")
    private String name;
    @NotNull(message = "teacherId.must.not.be.null")
    private Integer teacherId;
}
