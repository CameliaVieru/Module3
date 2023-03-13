package application1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Motocicleta implements IAutomobil{
    @Autowired
    private Motor motor;

    @Override
    public int travel() {
        return 500;
    }

    @Override
    public int maxDrivingSpeed() {
        return 200;
    }

    @Override
    public void sayName() {
        System.out.println("Motocicleta");
    }

    public Motor specificMotor(){
        this.motor.setNume("MotorMotocicleta");
        this.motor.setPutere(80);
        this.motor.setNumarCilindri(2);
        return this.motor;
    }
}
