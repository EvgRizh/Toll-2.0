package jdev.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import jdev.GPSPoint;
import jdev.Service.GPSSimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.atomic.AtomicLong;

import static java.lang.Thread.*;

/**
 * Created by jenia on 17.03.22.
 */
@RestController
public class GPSController {
    private GPSPoint point = new GPSPoint(55.3,48.3,45.5,36.8);

    @Autowired
    GPSSimService gpsSimService;

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/getgps")
    public GPSPoint setGPS() throws InterruptedException{
            point = gpsSimService.getGPS(point);
            return point;
    }
}
