package jdev;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jenia on 13.04.22.
 */
public class GPSPointTest {
    private GPSPoint point = new GPSPoint(48.2, 45.3, 35.0, 40.0);

    @Test
    public void toJson() throws Exception {
        assertTrue(point.toJson().contains("\"lat\":48.2"));
        assertTrue(point.toJson().contains("\"speed\":40.0"));
        System.out.println(point.toJson());
    }

    @Test
    public void gpsRandom() throws Exception {
        point.gpsRandom();
        assertFalse(point.getLat() == 48.2);
        assertFalse(point.getSpeed() == 40.0);
        System.out.println(point.toJson());
    }

    @Test
    public void toStringTest() throws Exception{
        assertEquals("GPSPoint{lat=48.2, lon=45.3, azimuth=35.0, speed=40.0}", point.toString());
        System.out.println(point.toString());
    }

}