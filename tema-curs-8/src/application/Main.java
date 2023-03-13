package application;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TeacherConfiguration.class);
        JavaTeacher theTeacher = context.getBean("javaTeacherFull", JavaTeacher.class);
        ITeacher math = context.getBean("mathTeacher", MathTeacher.class);
        ITeacher history = context.getBean("historyTeacher", HistoryTeacher.class);
        System.out.println(theTeacher.getHomework());
        System.out.println(theTeacher.getWisdom());
        System.out.println(theTeacher.getWorkplace());
        System.out.println(math.getWisdom());
        System.out.println(math.getHomework());
        System.out.println(history.getWisdom());
        System.out.println(history.getHomework());
    }
}