package application;

import org.springframework.stereotype.Component;

@Component("javaTeacher")
public class JavaTeacher implements ITeacher{
    private WisdomWordsService wisdomService;
    private HomeworkService homeworkService;
    private int age;
    private String workplace;

    public JavaTeacher(WisdomWordsService wisdomService, HomeworkService homeworkService) {
        this.wisdomService = wisdomService;
        this.homeworkService = homeworkService;
    }
    @Override
    public String getWisdom() {
        return "Smart Words by Java professor";
    }
    @Override
    public String getHomework() {
        return "Create 100 classes";
    }

    public int getAge() {
        return age;
    }

    public String getWorkplace() {
        return workplace;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setWorkplace(String workplace) {
        this.workplace = workplace;
    }
}
