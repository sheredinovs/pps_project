package airport.state;

import airport.Airport;
import airport.Plane;

/**
 * Created by kadyr on 06.12.2017.
 */
public class BlockedState extends UnlockedState {

    public BlockedState(Airport airport){
        super(airport);
    }

    @Override
    public void registerPlaneToLand(Plane basePlane) {
        System.out.println("Airport in blocked state! Can not register " + basePlane.getName() + " to land Please, free runways");
    }

}
