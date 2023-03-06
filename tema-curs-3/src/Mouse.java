public class Mouse implements IAnimal{
    private NameService name;

    public Mouse(NameService name){
        this.name = name;
    }
    @Override
    public String getName() {
        return name.getMessage() + "Maurice";
    }
}
