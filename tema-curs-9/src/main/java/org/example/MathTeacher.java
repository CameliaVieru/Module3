package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MathTeacher implements ITeacher{
    private WisdomWordsService wisdomService;

    @Override
    public String getWisdom() {
        return "Math: " + wisdomService.getMessage();
    }
    public String getHomework() {
        return "Solve 100 calculus problems";
    }

    @Autowired
    public void setWisdomService(WisdomWordsService wisdomSevice) {
        this.wisdomService = wisdomSevice;
    }
}
