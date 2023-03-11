package annotationApplicationEx2;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("annotationApplicationEx2/applicationContext.xml");
        ITeacher teacher = context.getBean("javaTeacher", ITeacher.class);
        ITeacher webTeacher = context.getBean(ITeacher.class);

        System.out.println(teacher.getHomeWork());
        context.close();
    }
}
