public class Dog implements IAnimal{
    private NameService name;

    public Dog(NameService name){
        this.name = name;
    }
    @Override
    public String getName() {
        return name.getMessage() + "Doggo";
    }
}
