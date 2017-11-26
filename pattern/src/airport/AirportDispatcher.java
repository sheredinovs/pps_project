package airport;

import command.AirPortCommonCommand;
import command.AirPortServiceCommand;

/**
 * Created by kadyr on 21.11.2017.
 */
public class AirportDispatcher {
    private static AirportDispatcher airportDispatcher;
    private Airport airport;
    private AirPortServiceCommand command;
    private AirPortCommonCommand commonCommand;

    private AirportDispatcher(AirPortServiceCommand command, Airport airport){
        this.command = command;
        this.airport = airport;
    }


    public static AirportDispatcher getInstance(AirPortServiceCommand command, Airport airport){
        if(airportDispatcher == null)
            airportDispatcher = new AirportDispatcher(command, airport);
        return airportDispatcher;
    }

    public void setServiceCommand(AirPortServiceCommand serviceCommand){
        if(serviceCommand == null){
            throw new IllegalArgumentException("command can not be null " + airportDispatcher);
        }
        this.command = serviceCommand;
    }

    public  void setCommonCommand(AirPortCommonCommand commonCommand){
        if(commonCommand == null){
            throw new IllegalArgumentException("command can not be null " + airportDispatcher);
        }
        this.commonCommand = commonCommand;
    }

    public void executeService(){
        command.execute(airport);
        executeCommon();
    }

    private void executeCommon(){
        if(commonCommand == null){
            throw new IllegalArgumentException("specify Common commander " + airportDispatcher);
        }
        commonCommand.execute(airport);
    }

}
