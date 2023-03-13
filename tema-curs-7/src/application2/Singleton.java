package application2;

public class Singleton {
    private static Singleton instance;

    private Singleton(){

    }
    public static Singleton getInstance(){
        if(Singleton.instance==null){
            Singleton.instance=new Singleton();
        }
        return Singleton.instance;
    }
}
