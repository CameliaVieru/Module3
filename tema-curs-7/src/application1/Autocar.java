package application1;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Autocar implements IAutomobil{

    private Motor motor;
    @Override
    public int travel() {
        return 800;
    }

    @Override
    public int maxDrivingSpeed() {
        return 150;
    }

    @Override
    public void sayName() {
        System.out.println("Autocar");
    }

    @Autowired
    public void setMotor(Motor motor) {
        this.motor = motor;
    }

    @Autowired
    public Motor getMotor() {
        return motor;
    }

    public Motor specificMotor(){
        this.motor.setPutere(5);
        this.motor.setNume("MotorAutocar");
        this.motor.setNumarCilindri(60);
        return this.motor;
    }

}
