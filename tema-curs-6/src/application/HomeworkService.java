package application;

import org.springframework.stereotype.Component;

@Component("homeworkService")
public class HomeworkService {
    private String message = "Homework";

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}