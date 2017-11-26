/**
 * Created by kadyr on 21.11.2017.
 */
public class BasePlane implements Plane {
    private String name;

    public BasePlane(String name){
        this.name = name;
    }

    public void fly(){
        System.out.println(name + " is flying");
    }

    public void land(){
        System.out.println(name + " is landing");
    }
}
