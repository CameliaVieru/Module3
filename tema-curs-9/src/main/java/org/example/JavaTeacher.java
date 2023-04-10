package org.example;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JavaTeacher implements ITeacher{
    private WisdomWordsService wisdomService;
    private HomeworkService homeworkService;
    @Getter
    @Setter
    private int age;
    @Getter
    @Setter
    private String workplace;

    @Autowired(required = false)
    public JavaTeacher(WisdomWordsService wisdomService) {
        this.wisdomService = wisdomService;
    }
    @Autowired(required = false)
    public JavaTeacher(WisdomWordsService wisdomService, HomeworkService homeworkService) {
        this.wisdomService = wisdomService;
        this.homeworkService = homeworkService;
    }
    @Override
    public String getWisdom() {
        return "Smart Words by Java professor";
    }
    @Override
    public String getHomework() {
        return "Create 100 classes";
    }

    public int getAge() {
        return age;
    }

    public String getWorkplace() {
        return workplace;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setWorkplace(String workplace) {
        this.workplace = workplace;
    }

    @Override
    public String toString() {
        return "JavaTeacher{" +
                "wisdomService=" + wisdomService.toString() +
                ", homeworkService=" + homeworkService.toString() +
                ", age=" + age +
                ", workplace='" + workplace + '\'' +
                '}';
    }
}
