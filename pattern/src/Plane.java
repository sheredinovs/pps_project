/**
 * Created by kadyr on 21.11.2017.
 */
public class Plane {
    private String name;

    public Plane(String name){
        this.name = name;
    }

    public void fly(){
        System.out.println(name + " is flying");
    }

    public void land(){
        System.out.println(name + " is landing");
    }
}
