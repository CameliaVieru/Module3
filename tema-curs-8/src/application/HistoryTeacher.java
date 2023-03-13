package application;

import org.springframework.stereotype.Component;

@Component
public class HistoryTeacher implements ITeacher{
    private WisdomWordsService wisdomService;
    public HistoryTeacher(WisdomWordsService wisdomService) {
        this.wisdomService = wisdomService;
    }
    @Override
    public String getWisdom() {
        return "History: " + wisdomService.getMessage();
    }
    @Override
    public String getHomework() {
        return "Learn about WW1";
    }
}
