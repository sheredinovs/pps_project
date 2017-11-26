/**
 * Created by kadyr on 26.11.2017.
 */
public class BasePlaneTest {
    private BasePlane plane;

    @org.junit.Before
    public void setUp() throws Exception {
        plane = new BasePlane("test plane");
    }

    @org.junit.After
    public void tearDown() throws Exception {
        plane = null;
    }

    @org.junit.Test
    public void fly() throws Exception {
        plane.fly();
    }

    @org.junit.Test
    public void land() throws Exception {
        plane.land();
    }

}