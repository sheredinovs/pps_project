package airport;

/**
 * Created by kadyr on 21.11.2017.
 */
public class BasePlane implements Plane {
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BasePlane)) return false;

        BasePlane basePlane = (BasePlane) o;

        return name.equals(basePlane.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    public BasePlane(String name){
        this.name = name;
    }

    public void fly(){
        System.out.println(name + " is flying");
    }

    public void land(){
        System.out.println(name + " is landing");
    }
    public String getName(){
        return name;
    }
}
