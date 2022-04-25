package jdev.service;

import jdev.GPSPointEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;


/**
 * Created by jenia on 18.03.22.
 */
@Service
public class GetGPSService {
    private static final Logger log = LoggerFactory.getLogger(GetGPSService.class);

    public GPSPointEntity readGPS(){
        RestTemplate restTemplate = new RestTemplate();
        GPSPointEntity response = restTemplate.getForObject("http://localhost:8080/getgps", GPSPointEntity.class);
        log.info(response.toString());
        return  response;
    }

//    public static void main(String... args) throws IOException, InterruptedException {
//        while (true) {
//            GetGPSService getGPSService = new GetGPSService();
//            getGPSService.readGPS();
//        }
//    }
}
