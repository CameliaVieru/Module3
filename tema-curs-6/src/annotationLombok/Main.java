package annotationLombok;

public class Main {
    public static void main(String[] args){
        TestingLombok test = new TestingLombok("Hello", "test");
        System.out.println(test.getString());
        System.out.println(test.getSecondString());

        test.setString("bonjour");
        test.setSecondString("Jimmy");

        System.out.println(test.getString());
        System.out.println(test.getSecondString());

    }
}
