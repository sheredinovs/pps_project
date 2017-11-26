import airport.Airport;
import airport.BasePlane;
import airport.Plane;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by kadyr on 26.11.2017.
 */
public class AirportTest {
    private Airport airport;

    @Before
    public void setUp() throws Exception {
        airport = Airport.getInstance();
    }

    @After
    public void tearDown() throws Exception {
        airport.releaseAllResources();
        airport = null;
    }

    @Test
    public void getInstance() throws Exception {
        Airport testAirport = Airport.getInstance();
        boolean isSame = airport == testAirport;
        Assert.assertTrue(isSame);
    }

    @Test
    public void getPlaneToFly() throws Exception {
        String plane1Name = "plane1";
        String plane2Name = "plane2";
        String plane3Name = "plane3";
        BasePlane plane = new BasePlane(plane1Name);
        BasePlane plane1 = new BasePlane(plane2Name);
        BasePlane plane2 = new BasePlane(plane3Name);
        airport.registerPlaneToFly(plane);
        airport.registerPlaneToFly(plane1);
        airport.registerPlaneToFly(plane2);
        BasePlane planeTest1 = (BasePlane) airport.getPlaneToFly();
        BasePlane planeTest2 = (BasePlane) airport.getPlaneToFly();
        BasePlane planeTest3 = (BasePlane) airport.getPlaneToFly();

        Assert.assertEquals(plane, planeTest1);
        Assert.assertEquals(plane1, planeTest2);
        Assert.assertEquals(plane2, planeTest3);

    }

    @Test
    public void getPlaneToLand() throws Exception {
    }

    @Test
    public void registerPlaneToFly() throws Exception {
        String planeName = "testPlaneToFly";
        Assert.assertTrue(airport.getPlaneToFly() == null);
        airport.registerPlaneToFly(new BasePlane(planeName));
        Plane plane = airport.getPlaneToFly();
        Assert.assertTrue(plane != null);
        Assert.assertEquals(planeName, plane.getName());

    }

    @Test
    public void registerPlaneToLand() throws Exception {
        String planeName = "testPlaneToLand";
        Assert.assertTrue(airport.getPlaneToLand() == null);
        airport.registerPlaneToLand(new BasePlane(planeName));
        Plane plane = airport.getPlaneToLand();
        Assert.assertTrue(plane != null);
        Assert.assertEquals(planeName, plane.getName());
    }

}