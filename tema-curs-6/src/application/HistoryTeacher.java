package application;

import org.springframework.stereotype.Component;

@Component("historyTeacher")
public class HistoryTeacher implements ITeacher{
    private WisdomWordsService wisdomService;
    public HistoryTeacher(WisdomWordsService wisdomService) {
        this.wisdomService = wisdomService;
    }
    @Override
    public String getWisdom() {
        return wisdomService.getMessage();
    }
    public String getHomework() {
        return "Learn about WW1";
    }
}
