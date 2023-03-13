package application1;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Masina implements IAutomobil{

    private Motor motor;

    @Autowired
    public Masina(Motor motor){
        this.motor = motor;
    }
    public void sayName(){
        System.out.println("Masina");
    }

    @Override
    public Motor specificMotor() {
        this.motor.setNumarCilindri(8);
        this.motor.setNume("MotorMasina");
        this.motor.setPutere(100);
        return this.motor;
    }

    @Override
    public int travel() {
        return 200;
    }

    @Override
    public int maxDrivingSpeed() {
        return 180;
    }

}
