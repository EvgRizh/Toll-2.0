package jdev.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import jdev.GPSPointEntity;
import jdev.Service.GPSSimService;
import jdev.dao.repo.GPSPointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class GetNPoint {

    @Autowired
    GPSPointRepository gpsPointRepository;

    @RequestMapping(value = "/getngps", method = RequestMethod.GET)
    public String GetNGPS(@RequestParam(required = false) int n) {
        List<GPSPointEntity> pointAll;
        pointAll = (List<GPSPointEntity>) gpsPointRepository.findAll();
        pointAll = pointAll.subList(pointAll.size() - Math.min(n, pointAll.size()), pointAll.size());
        return pointAll.toString();
    }
}
