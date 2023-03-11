package application1;

import org.springframework.stereotype.Component;

@Component("prototypeBean")
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
