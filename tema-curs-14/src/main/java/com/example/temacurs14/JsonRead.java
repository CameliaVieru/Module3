package com.example.temacurs14;

import Model.Course;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class JsonRead {
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Course course = objectMapper.readValue(new File("src/main/resources/FirstJson.json"), Course.class);
        ArrayList<Course> arrayListCourse = objectMapper.readValue(new File("src/main/resources/SecondJson.json"), ArrayList.class);
        System.out.println(course.toString());
        System.out.println(arrayListCourse.toString());
    }
}
