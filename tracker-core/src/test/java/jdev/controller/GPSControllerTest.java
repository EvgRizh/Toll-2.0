package jdev.controller;

import jdev.GPSPoint;
import jdev.Service.GPSSimService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by jenia on 20.04.22.
 */
@RunWith(value = MockitoJUnitRunner.class)
public class GPSControllerTest {

    @Test
    public void setGPS() throws Exception {
        GPSPoint point = null;
        GPSController gpsController = new GPSController();
        String result = gpsController.setGPS(point);
        assertEquals("{success:\"false\"}", result);
        System.out.println(result);
        point = new GPSPoint(56.2,48.3,36.155,45);
        result = gpsController.setGPS(point);
        assertEquals("{success:\"true\"}", result);
        System.out.println(result);
    }

    @Mock
    RestTemplate restTemplate;

    @Mock
    GPSSimService gpsSimService;

    @InjectMocks
    GPSController gpsController = new GPSController();

    @Test
    public void getGPS() throws Exception {
        when(gpsSimService.getGPS()).thenReturn(new GPSPoint(56.2,48.3,36.155,45));
        when(restTemplate.postForObject("http://localhost:8080/gps", gpsSimService.getGPS(), String.class)).thenReturn("{success:\"true\"}");
        String result = gpsController.getGPS();
        assertEquals("{success:\"true\"}", result);
        System.out.println(result);
    }

    @Test
    public void getGPSIntegration() throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        GPSPoint point = new GPSPoint(56.2,48.3,36.155,45);
        String response = restTemplate.postForObject("http://localhost:8080/gps", point, String.class);
        assertEquals("{success:\"true\"}", response);
    }

}