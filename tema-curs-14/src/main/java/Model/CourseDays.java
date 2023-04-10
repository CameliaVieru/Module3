package Model;

import lombok.Getter;
import lombok.Setter;

public class CourseDays {

    @Getter
    @Setter
    private String day;
    @Getter@Setter
    private String startingHour;

    @Override
    public String toString() {
        return "CourseDays{" +
                "day='" + day + '\'' +
                ", hour='" + startingHour + '\'' +
                '}';
    }
}
