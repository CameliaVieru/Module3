package application1;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Data
@Component
public class AutomobilService {
    @Autowired(required = false)
    private Autocar autocar;
    private Motocicleta motocicleta;
    private Masina masina;

    @Autowired
    public AutomobilService(Motocicleta motocicleta){
        this.motocicleta = motocicleta;
    }

    @Autowired(required = false)
    public void setMasina(Masina masina){
        this.masina = masina;
    }

    public void contains(){
        masina.sayName();
        autocar.sayName();
        motocicleta.sayName();
    }

}
