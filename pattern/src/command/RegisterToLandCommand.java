package command;

import airport.Airport;
import airport.Plane;

import java.util.List;

/**
 * Created by kadyr on 26.11.2017.
 */
public class RegisterToLandCommand implements AirPortServiceCommand {

    @Override
    public void execute(Airport airport, List<Plane> planes) {
        for (Plane plane : planes){
            airport.registerPlaneToLand(plane);
        }
    }
}
