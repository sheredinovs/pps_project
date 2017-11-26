package command;

import airport.Airport;
import airport.Plane;

import java.util.List;

/**
 * Created by kadyr on 26.11.2017.
 */
public class RegisterToFlyCommand implements AirPortServiceCommand {
    private List<Plane> planeList;

    public RegisterToFlyCommand(List<Plane> planes){
        this.planeList = planes;
    }

    @Override
    public void execute(Airport airport) {
        for (Plane plane : planeList){
            airport.registerPlaneToFly(plane);
        }
    }
}
