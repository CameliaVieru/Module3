package com.example.temacurs13;

import com.github.javafaker.Faker;
import com.github.javafaker.HarryPotter;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.TimeZone;

@RestController
public class SpringController {
    Faker faker = new Faker();

    @GetMapping("/time")
    public String currentZoneTime(@RequestParam String timeZone){
        TimeZone1 timeZ = new TimeZone1(timeZone);
        return timeZ.getTimeZone();
    }

    @GetMapping("/harry-potter")
    public String harryPotterName(){
        HarryPotter harryPotter = faker.harryPotter();
        return harryPotter.character();
    }

    @PostMapping("/math-service")
    public Double operations(@RequestBody Operations operations) {
        if(operations.getFirstNumber() == null || operations.getSecondNumber() == null){
            return -1d;
        }
        String firstNumber = operations.getFirstNumber();
        String secondNumber = operations.getSecondNumber();
        String operation = operations.getOperation();
        Double firstNr = Double.parseDouble(firstNumber);
        Double secondNr = Double.parseDouble(secondNumber);
        if (operation.equals("sum")) {
            operations.setResult(firstNr + secondNr);
            return operations.getResult();
        } else if (operation.equals("difference")) {
            return firstNr - secondNr;
        } else if (operation.equals("multiply")){
            return firstNr * secondNr;
        } else if(operation.equals("divide")){
            return firstNr/secondNr;
        } else if(operation.equals("power")){
           return Math.pow(firstNr.doubleValue(), secondNr.doubleValue());
        }
        return -1d;
    }
}
