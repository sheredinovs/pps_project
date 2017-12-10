import airport.AirportManager;

import java.io.IOException;

/**
 * Created by kadyr on 21.11.2017.
 */
public class AirportClient {
    public static void main(String[] args) throws IOException {
        AirportManager manager = AirportManager.getInstance();
        manager.manage();
    }
}
