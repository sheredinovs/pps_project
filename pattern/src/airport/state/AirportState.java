package airport.state;

import airport.Plane;

/**
 * Created by kadyr on 06.12.2017.
 */
public interface AirportState {

    public void registerPlaneToFly(Plane basePlane);

    public void registerPlaneToLand(Plane basePlane);

}
