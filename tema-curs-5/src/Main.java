import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println(Task.getNumberOfTasks());
        Task task1 = context.getBean("task", Task.class);
        System.out.println("Task 1: " + task1.toString());
        System.out.println(Task.getNumberOfTasks());
        Task task2 = context.getBean("task", Task.class);
        //task2.run();
        System.out.println("Task 2: " + task2.toString());
        System.out.println(Task.getNumberOfTasks());
        Task task3 = context.getBean("task", Task.class);
        System.out.println("Task 3: " + task3.toString());
        System.out.println(Task.getNumberOfTasks());
        task1.destroy();
        task2.destroy();
        task3.destroy();

        context.close();
        System.out.println("Final number of tasks: " + Task.getNumberOfTasks());

    }
}