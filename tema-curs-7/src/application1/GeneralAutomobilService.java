package application1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GeneralAutomobilService {
    private IAutomobil automobil;

    @Autowired
    public GeneralAutomobilService(Masina masina){
        this.automobil = masina;
    }

    public void printName(){
        automobil.sayName();
    }


}
