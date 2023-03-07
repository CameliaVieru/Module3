import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Task {
    private String taskName;
    private Integer taskId;
    private Integer executionTime;
    private static Integer numberOfTasks = 0;

    public void run(){
        try {
            TimeUnit.SECONDS.sleep(executionTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Integer generateId(Integer number){
        Random random = new Random();
        return random.nextInt(number);
    }

    public static Integer getNumberOfTasks() {
        return numberOfTasks;
    }

    public static void setNumberOfTasks(Integer numberOfTasks) {
        Task.numberOfTasks = numberOfTasks;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskName='" + taskName + '\'' +
                ", taskId=" + taskId +
                ", executionTime=" + executionTime +
                '}';
    }

    public void init(){
        Task.setNumberOfTasks(Task.getNumberOfTasks()+1);
        this.taskId = generateId(1000);
        this.taskName = "Task " + taskId;
        this.executionTime = generateId(20);
    }

    public void destroy(){
        System.out.println("This task was destroyed: " + this.taskName);
        Task.setNumberOfTasks(Task.getNumberOfTasks()-1);
        System.out.println(numberOfTasks);
    }
}
