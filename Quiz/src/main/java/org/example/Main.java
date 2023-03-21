package org.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(StudentConfiguration.class);
        Student firstStudent = context.getBean("student", Student.class);
        Student anotherfirstStudent = context.getBean("student", Student.class);
        System.out.println(firstStudent.getFirstName());
        System.out.println(firstStudent + " " + anotherfirstStudent);
        Student secondStudent = context.getBean("studentPrototype", Student.class);
        Student anothersecondStudent = context.getBean("studentPrototype", Student.class);
        System.out.println(secondStudent + " " + anothersecondStudent);
        System.out.println(firstStudent.getFirstName());
    }
}