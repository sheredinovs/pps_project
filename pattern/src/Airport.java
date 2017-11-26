import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by kadyr on 21.11.2017.
 */
public class Airport {
    private Queue<Plane> planesToFly;
    private Queue<Plane> planesToLand;
    private static Airport airport;

    public Airport getInstance(){
        if(airport == null)
            airport = new Airport();
        return airport;
    }

    private Airport(){
        planesToFly = new ArrayDeque<>();
        planesToLand = new ArrayDeque<>();
    }

    public Plane getPlaneToFly(){
        return planesToFly.peek();
    }

    public Plane getPlaneToLand(){
        return planesToLand.peek();
    }

    public void registerPlaneToFly(Plane basePlane){
        planesToFly.add(basePlane);
    }

    public void registerPlaneToLand(Plane basePlane){
        planesToLand.add(basePlane);
    }

}
