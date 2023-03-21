package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan("org.example")
public class StudentConfiguration {

    @Bean("student")
    public Student singletonStudent(){
        Student student = new Student("First", "Last", 3);
        return student;
    }

    @Bean("studentPrototype")
    @Scope("prototype")
    public Student protorypeStudent(){
        return new Student("A", "B", 2);
    }
}
