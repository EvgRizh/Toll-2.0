package jdev;

import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.*;

/**
 * Created by jenia on 21.04.22.
 */
public class GetGPSTest {

    @Test
    public void readGPS() throws Exception {
        GetGPS getGPS = new GetGPS();
        String response = getGPS.readGPS();
        System.out.println(response);
        assertTrue(response.contains("{success:\"true\"}"));
    }

}