/**
 * Created by kadyr on 21.11.2017.
 */
public class AirportDispatcher {
    private static AirportDispatcher airportDispatcher;
    private AirPortCommand command;

    private AirportDispatcher(AirPortCommand command){
        this.command = command;
    }


    public AirportDispatcher getInstance(AirPortCommand command){
        if(airportDispatcher == null)
            airportDispatcher = new AirportDispatcher(command);
        return airportDispatcher;
    }


}
