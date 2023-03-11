package annotationLombok;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class TestingLombok {

    @Getter
    @Setter
    private String string;

    private String secondString;

    public TestingLombok(String string, String secondString){
        this.string = string;
        this.secondString = secondString;
    }
}
