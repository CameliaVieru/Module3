package application;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application/applicationContext.xml");

        JavaTeacher java = context.getBean("javaTeacher", JavaTeacher.class);
        ITeacher math = context.getBean("mathTeacher", MathTeacher.class);
        ITeacher history = context.getBean("historyTeacher", HistoryTeacher.class);

        System.out.println(java.getHomework());
        System.out.println(java.getWisdom());
        System.out.println(math.getHomework());
        System.out.println(history.getHomework());

        context.close();
    }
}
