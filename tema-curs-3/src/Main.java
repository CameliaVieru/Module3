import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        IAnimal dog = context.getBean("dog", Dog.class);
        IAnimal cat = context.getBean("cat", Cat.class);
        IAnimal mouse = context.getBean("mouse", Mouse.class);
        System.out.println(dog.getName());
        System.out.println(cat.getName());
        System.out.println(mouse.getName());

        context.close();
    }
}