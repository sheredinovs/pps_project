package airport;

import command.FlyCommonCommand;
import command.LandCommonCommand;
import command.RegisterToFlyCommand;
import command.RegisterToLandCommand;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kadyr on 10.12.2017.
 */
public class AirportManager {
    private static AirportManager airportManager;
    private AirportDispatcher airportDispatcher;

    public static AirportManager getInstance(){
        if(airportManager == null)
            airportManager = new AirportManager();
        return airportManager;
    }

    public void manage() throws IOException {
        while (true) {
            System.out.println("Введите команды и кол-во самолетов через пробел:");
            String[] commands = getCommand().split(" ");
            if ("fly".equals(commands[0])) {
                int count = Integer.parseInt(commands[1]);
                List<Plane> listToFly = new ArrayList<>();
                for (int i = 0; i < count; i++) {
                    listToFly.add(new BasePlane("Plane " + count));
                }
                getFlyingDispatcher().executeService(listToFly);
            }
            if ("land".equals(commands[2])) {
                int count = Integer.parseInt(commands[3]);
                List<Plane> listToLand = new ArrayList<>();
                for (int i = 0; i < count; i++) {
                    listToLand.add(new BasePlane("Plane " + count));
                }
                getLandingDispatcher().executeService(listToLand);
            }
        }
    }

    private AirportDispatcher getFlyingDispatcher(){
        this.airportDispatcher =  AirportDispatcher.getInstance(new RegisterToFlyCommand(), Airport.getInstance());
        airportDispatcher.setServiceCommand(new RegisterToLandCommand());
        airportDispatcher.setCommonCommand(new FlyCommonCommand());
        return airportDispatcher;
    }


    private AirportDispatcher getLandingDispatcher() {
        this.airportDispatcher =  AirportDispatcher.getInstance(new RegisterToLandCommand(), Airport.getInstance());
        airportDispatcher.setServiceCommand(new RegisterToLandCommand());
        airportDispatcher.setCommonCommand(new LandCommonCommand());
        return airportDispatcher;

    }

    private String getCommand() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        StringBuilder line = new StringBuilder(br.readLine());
        return line.toString();
    }
}
