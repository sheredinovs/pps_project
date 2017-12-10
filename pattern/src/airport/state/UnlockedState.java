package airport.state;

import airport.Airport;
import airport.Plane;

/**
 * Created by kadyr on 10.12.2017.
 */
public class UnlockedState implements AirportState{
    Airport airport;

    public UnlockedState(Airport airport){
        this.airport = airport;
    }

    @Override
    public void registerPlaneToFly(Plane basePlane) {
        airport.getAllPlanesToFly().add(basePlane);
        System.out.println(basePlane.getName() + " registered to fly");
    }

    @Override
    public void registerPlaneToLand(Plane basePlane) {
        airport.getAllPlanesToLand().add(basePlane);
        System.out.println(basePlane.getName() + " registered to land");

    }
}
