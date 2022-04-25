package jdev.Service;

import jdev.GPSPointEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jenia on 01.03.22.
 */
@Service
public class GPSSimService {

    @Autowired
    GPSPointEntity gpsPointEntity;

    public GPSPointEntity point = new GPSPointEntity(48.2, 52.4, 17.25, 38.0);

    public GPSPointEntity getGPS() throws InterruptedException {
        while (true) {
            point.gpsRandom();
            return point;
        }
    }
}