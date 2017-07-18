/**
 * Created by lab on 15.07.2017.
 */
public class Animal {
    private final String name;

    public Animal (String name){
        this.name = name;
    }
    @Override
    public String toString() {
        return "Animal with name " + name;


    }
}
