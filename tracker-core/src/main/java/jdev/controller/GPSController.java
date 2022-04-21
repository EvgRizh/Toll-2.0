package jdev.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import jdev.GPSPoint;
import jdev.Service.GPSSimService;
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


    @RequestMapping(value = "/gps", method = RequestMethod.POST)
    public String setGPS(@RequestBody GPSPoint pt) {
        if (pt == null) return "{success:\"false\"}";
        else return "{success:\"true\"}";
    }

    @RequestMapping("/getgps")
    public  String getGPS() throws InterruptedException, JsonProcessingException {
            String response = restTemplate.postForObject("http://localhost:8080/gps", gpsSimService.getGPS(), String.class);
            return response;
    }
}
