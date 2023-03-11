package annotationApplicationEx2;

import org.springframework.stereotype.Component;

@Component
public class JavaTeacher implements ITeacher{

    public String getHomeWork() {
        return "Create 100 classes";
    }
}
