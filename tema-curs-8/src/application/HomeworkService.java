package application;

import org.springframework.stereotype.Component;

@Component
public class HomeworkService {
    private String message = "Homework";

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "HomeworkService{" +
                "message='" + message + '\'' +
                '}';
    }
}
