import airport.Airport;
import airport.AirportDispatcher;
import airport.BasePlane;
import airport.Plane;
import command.FlyCommonCommand;
import command.LandCommonCommand;
import command.RegisterToFlyCommand;
import command.RegisterToLandCommand;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kadyr on 21.11.2017.
 */
public class AirportClient {
    private final static List<Plane> listToFly;
    private final static List<Plane> listToLand;
    static {
        Plane pegas = new BasePlane("Pagas");
        Plane aironix = new BasePlane("Aironix");
        Plane atlas = new BasePlane("Atlas");
        listToFly = new ArrayList<>();
        listToFly.add(pegas);
        listToFly.add(aironix);
        listToFly.add(atlas);

        Plane lufthansa = new BasePlane("Lufthansa");
        Plane delta = new BasePlane("Delta Air");
        Plane ryanair = new BasePlane("Ryanair");
        listToLand = new ArrayList<>();
        listToLand.add(lufthansa);
        listToLand.add(delta);
        listToLand.add(ryanair);
    }
    public static void main(String[] args) {
        Airport airport = Airport.getInstance();

        AirportDispatcher airportDispatcher = AirportDispatcher.getInstance(new RegisterToFlyCommand(listToFly), airport);
        airportDispatcher.setCommonCommand(new FlyCommonCommand());
        airportDispatcher.executeService();

        airportDispatcher.setServiceCommand(new RegisterToLandCommand(listToLand));
        airportDispatcher.setCommonCommand(new LandCommonCommand());
        airportDispatcher.executeService();
    }
}
