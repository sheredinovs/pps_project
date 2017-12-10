package airport;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by kadyr on 10.12.2017.
 */
public class AirportManagerTest {
    @Test
    public void getInstance() throws Exception {
        AirportManager manager1 = AirportManager.getInstance();
        Assert.assertTrue(manager1 == AirportManager.getInstance());
    }


    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void manageException() throws IOException {
        AirportManager manager1 = AirportManager.getInstance();
    }
}