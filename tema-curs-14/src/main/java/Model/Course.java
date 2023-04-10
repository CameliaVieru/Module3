package Model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class Course {
    @Getter@Setter
    private String courseName;
    @Getter@Setter
    private Trainer trainer;
    @Getter@Setter
    private boolean online;
    @Getter@Setter
    private List<CourseDays> courseDays;

    @Override
    public String toString() {
        return "Course{" +
                "name='" + courseName + '\'' +
                ", trainer=" + trainer.toString() +
                ", online=" + online +
                ", courseDays=" + courseDays.toString() +
                '}';
    }
}
