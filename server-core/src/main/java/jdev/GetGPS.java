package jdev;

import org.apache.commons.io.IOUtils;
import org.springframework.web.client.RestTemplate;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import java.io.IOException;
import java.net.URL;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;


/**
 * Created by jenia on 18.03.22.
 */
public class GetGPS {
    private static final Logger log = LoggerFactory.getLogger(GetGPS.class);

    public static void main(String... args) throws IOException, InterruptedException {
        while (true) {
            GPSPoint point = new GPSPoint();
            RestTemplate restTemplate = new RestTemplate();
            point = restTemplate.postForObject("http://localhost:8080/getgps",point, GPSPoint.class);
//            String response = IOUtils.toString(new URL("http://localhost:8080/get"), "UTF8");
            if (point.toJson().split(",").length == 4) log.info("{success:\"true\"}");
            else log.info("{success:\"false\"}");
            Thread.sleep(1000);
        }
    }
}
