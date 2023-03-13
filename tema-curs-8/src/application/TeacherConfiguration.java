package application;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan("application")
public class TeacherConfiguration {
    @Bean
    public WisdomWordsService wisdomWordsService(){
        return new WisdomWordsService();
    }
    @Bean
    public HomeworkService homeworkService(){
        return new HomeworkService();
    }

    @Bean("javaTeacherFull")
    @Scope("prototype")
    public JavaTeacher javaTeacherFull(){
        JavaTeacher javaTeacher = new JavaTeacher(wisdomWordsService(), homeworkService());
        javaTeacher.setAge(25);
        javaTeacher.setWorkplace("Devmind");
        return javaTeacher;
    }
    @Bean("javaTeacher")
    public JavaTeacher javaTeacher(){
        return new JavaTeacher(wisdomWordsService());
    }

    @Bean
    public MathTeacher mathTeacher(){
        MathTeacher mathTeacher = new MathTeacher();
        mathTeacher.setWisdomService(wisdomWordsService());
        return mathTeacher;
    }
    @Bean HistoryTeacher historyTeacher(){
        return  new HistoryTeacher(wisdomWordsService());
    }
}
