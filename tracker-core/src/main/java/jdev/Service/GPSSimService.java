package jdev.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import jdev.GPSPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by jenia on 01.03.22.
 */
@Service
public class GPSSimService {
    private GPSPoint point = new GPSPoint(56.2,48.3,36.155,45);

    public GPSPoint getGPS(GPSPoint point) throws InterruptedException {
        while (true) {
            Thread.sleep(1000);
            point.gpsRandom();
            return point;
        }
    }
}


