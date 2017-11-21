import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by kadyr on 21.11.2017.
 */
public class Airport {
    public Queue<Plane> planesToFly;
    public Queue<Plane> planesToLand;

    public Airport(){
        planesToFly = new ArrayDeque<>();
        planesToLand = new ArrayDeque<>();
    }

    public Plane getPlaneToFly(){
        return planesToFly.peek();
    }

    public Plane getPlaneToLand(){
        return planesToLand.peek();
    }

    public void registerPlaneToFly(Plane plane){
        planesToFly.add(plane);
    }

    public void registerPlaneToLand(Plane plane){
        planesToLand.add(plane);
    }

}
