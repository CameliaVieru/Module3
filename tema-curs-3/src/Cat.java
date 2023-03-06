public class Cat implements IAnimal {
    private NameService name;

    public Cat(NameService name){
        this.name = name;
    }
    @Override
    public String getName() {
        return name.getMessage() + "Katz";
    }
}
