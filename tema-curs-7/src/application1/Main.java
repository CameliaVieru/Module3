package application1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application1/applicationContext.xml");
        AutomobilService automobilService = context.getBean("automobilService", AutomobilService.class);
        automobilService.contains();
        System.out.println("Autocar viteza: " + automobilService.getAutocar().maxDrivingSpeed());
        System.out.println("Autocar distanta parcursa: " + automobilService.getAutocar().travel());
        System.out.println("Masina viteza: " + automobilService.getMasina().maxDrivingSpeed());
        System.out.println("Masina distanta parcursa: "+ automobilService.getMasina().travel());
        System.out.println("Motocicleta viteza: " + automobilService.getMotocicleta().maxDrivingSpeed());
        System.out.println("Motocicleta distanta parcursa: " + automobilService.getMotocicleta().travel());
        Autocar autocar = automobilService.getAutocar();
        System.out.println(autocar.specificMotor());
        Masina masina = automobilService.getMasina();
        System.out.println(masina.specificMotor());
        Motocicleta motocicleta = automobilService.getMotocicleta();
        System.out.println(motocicleta.specificMotor());

        GeneralAutomobilService generalService = context.getBean("generalAutomobilService", GeneralAutomobilService.class);
        generalService.printName();
    }
}