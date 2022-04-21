package jdev;

import org.apache.commons.io.IOUtils;
import org.springframework.web.client.RestTemplate;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import java.io.IOException;
import java.net.URL;
import jdev.GPSPoint.*;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;


/**
 * Created by jenia on 18.03.22.
 */
public class GetGPS {
    private static final Logger log = LoggerFactory.getLogger(GetGPS.class);

    public String readGPS(){
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject("http://localhost:8080/getgps", String.class);
        log.info(response);
        return  response;
    }

    public static void main(String... args) throws IOException, InterruptedException {
        while (true) {
            GetGPS getGPS = new GetGPS();
            getGPS.readGPS();
        }
    }
}
