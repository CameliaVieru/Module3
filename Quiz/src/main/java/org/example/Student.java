package org.example;

import org.springframework.stereotype.Component;

@Component
public class Student {
    private String firstName;
    private String lastName;
    private int grade;

    public Student(String firstName, String lastName, int gratd){
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getFirstName() {
        return "firstName";
    }

    public String getLastName() {
        return "lastName";
    }

    public int getGrade() {
        return 10;
    }
}
