package Model;

import lombok.Getter;
import lombok.Setter;

public class Trainer {
    @Getter@Setter
    private String name;
    @Getter@Setter
    private Integer zoomId;

    @Override
    public String toString() {
        return "Trainer{" +
                "name='" + name + '\'' +
                ", zoomId=" + zoomId +
                '}';
    }
}
