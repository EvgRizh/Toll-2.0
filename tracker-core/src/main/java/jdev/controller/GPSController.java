package jdev.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import jdev.Service.GPSSimService;
import jdev.GPSPointEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;



/**
 * Created by jenia on 17.03.22.
 */
@RestController
public class GPSController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    GPSSimService gpsSimService;

    @Autowired
    GPSPointEntity gpsPointEntity;


    @RequestMapping(value = "/gps", method = RequestMethod.POST)
    public GPSPointEntity setGPS(@RequestBody GPSPointEntity pt) {
        return pt;
    }

    @RequestMapping("/getgps")
    public  GPSPointEntity getGPS() throws InterruptedException, JsonProcessingException {
            GPSPointEntity response = restTemplate.postForObject("http://localhost:8080/gps", gpsSimService.getGPS(), GPSPointEntity.class);
            return response;
    }
}
