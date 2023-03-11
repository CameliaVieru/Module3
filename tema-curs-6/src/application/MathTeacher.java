package application;

import org.springframework.stereotype.Component;

@Component("mathTeacher")
public class MathTeacher implements ITeacher{
    private WisdomWordsService wisdomService;

    @Override
    public String getWisdom() {
        return "Math: " + wisdomService.getMessage();
    }
    public String getHomework() {
        return "Solve 100 calculus problems";
    }

    public void setWisdomService(WisdomWordsService wisdomSevice) {
        this.wisdomService = wisdomSevice;
    }
}

