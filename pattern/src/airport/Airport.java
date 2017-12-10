package airport;

import airport.state.AirportState;
import airport.state.BlockedState;
import airport.state.UnlockedState;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by kadyr on 21.11.2017.
 */
public class Airport {
    private Queue<Plane> planesToFly;
    private Queue<Plane> planesToLand;
    private static Airport airport;
    private AirportState blockedState;
    private AirportState unlockedState;

    private final int PLANES_MAX_COUNT = 2;

    private AirportState state;


    public static Airport getInstance(){
        if(airport == null)
            airport = new Airport();
        return airport;
    }

    private Airport(){
        planesToFly = new ArrayDeque<>();
        planesToLand = new ArrayDeque<>();
        blockedState = new BlockedState(this);
        unlockedState = new UnlockedState(this);
        checkAndLock();
    }

    public Plane getPlaneToFly(){
        checkAndLock();
        return planesToFly.poll();
    }

    public Plane getPlaneToLand(){
        checkAndLock();
        return planesToLand.poll();
    }

    public void registerPlaneToFly(Plane basePlane){
        checkAndLock();
        state.registerPlaneToFly(basePlane);
    }

    public void registerPlaneToLand(Plane basePlane){
        checkAndLock();
        state.registerPlaneToLand(basePlane);
    }

    public void releaseAllResources(){
        this.planesToLand.clear();
        this.planesToFly.clear();
        checkAndLock();
    }

    public void releaseToFly(){
        planesToFly.clear();
        checkAndLock();
    }

    public void releaseToLand(){
        planesToLand.clear();
        checkAndLock();
    }

    public Queue<Plane> getAllPlanesToFly(){
        return planesToFly;
    }
    public Queue<Plane> getAllPlanesToLand(){
        return planesToLand;
    }

    private void checkAndLock(){
        if(planesToFly.size() >= PLANES_MAX_COUNT || planesToLand.size() >= PLANES_MAX_COUNT){
            this.state = blockedState;
        }
        else{
            this.state = unlockedState;
        }
    }
}
