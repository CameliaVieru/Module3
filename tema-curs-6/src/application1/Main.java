package application1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        System.out.println("---Before context initialization");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application1/applicationContext.xml");
        System.out.println("---Before getBean calls");

        context.getBean("prototypeBean", MyBean.class);
        context.getBean("prototypeBean", MyBean.class);
        context.getBean("prototypeBean", MyBean.class);

        System.out.println("---After getBean calls");
        System.out.println("Current nr of instances: " + MyBean.objectCounter);

        // close the context
        context.close();
        System.out.println("---After context closed");
        System.out.println("Current nr of instances: " + MyBean.objectCounter);


    }
}