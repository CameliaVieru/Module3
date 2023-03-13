package application2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("prototypeBean")
@Scope("singleton")
public class MyBean {
    static int objectCounter = 0;

    public MyBean(){
        objectCounter++;
        System.out.println("Current number of instances: "+ objectCounter);
    }

    private void init(){
        System.out.println("This method is called at initialization");
    }

    private void destroy(){
        objectCounter--;
        System.out.println("This method is called at destruction. Use this to free resources");
    }
}
