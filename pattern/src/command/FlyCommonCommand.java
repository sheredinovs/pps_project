package command;

import airport.Airport;
import airport.Plane;

import java.util.Queue;

/**
 * Created by kadyr on 21.11.2017.
 */
public class FlyCommonCommand implements AirPortCommonCommand {
    @Override
    public void execute(Airport airport) {
        Queue<Plane> planeList = airport.getAllPlanesToFly();
        if(planeList == null || planeList.isEmpty()){
            System.out.println("no planes to fly");
            return;
        }
        for (Plane plane : planeList){
            plane.fly();
        }
        airport.releaseToFly();
    }
}
