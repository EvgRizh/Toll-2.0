package jdev;

import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * Created by jenia on 01.03.22.
 */
public class GPSPointMain {
    public static void main(String[] args) throws JsonProcessingException {
        GPSPoint point = new GPSPoint(56.2, 45.8, 33, 45);
        System.out.println(point.toString());
        System.out.println(point.toJson());
        point.gpsRandom();
        System.out.println(point);
    }
}
