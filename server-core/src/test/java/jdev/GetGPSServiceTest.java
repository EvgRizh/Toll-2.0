package jdev;

import jdev.service.GetGPSService;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.*;

/**
 * Created by jenia on 21.04.22.
 */
public class GetGPSServiceTest {

    @Test
    public void readGPS() throws Exception {
        GetGPSService getGPSService = new GetGPSService();
        GPSPointEntity response = getGPSService.readGPS();
        System.out.println(response);
        assertNotNull(response);
    }

}