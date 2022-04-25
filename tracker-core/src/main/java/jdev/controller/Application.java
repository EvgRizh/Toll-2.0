package jdev.controller;

import jdev.Service.GPSSimService;
import jdev.GPSPointEntity;
import jdev.dao.repo.GPSRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by jenia on 17.03.22.
 */
@EnableJpaRepositories("jdev.dao")
@EntityScan(basePackageClasses = jdev.GPSPointEntity.class)
@ComponentScan
@EnableAutoConfiguration
public class Application implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(Application.class);
    private List<GPSPointEntity> all;

    @Autowired
    private GPSSimService gpsSimService;

    @Autowired
    private GPSRepository gpsRepository;

    @Autowired
    private GPSPointEntity pointEntity;

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public GPSSimService gpsSimService() {
        return new GPSSimService();
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder
                .setConnectTimeout(2000)
                .setReadTimeout(2000)
                .build();
    }

    @Bean
    public GPSPointEntity gpsPointEntity() {
        return new GPSPointEntity();
    }

    @Override
    public void run(String... args) throws Exception {
        while (true){
            pointEntity = gpsSimService.getGPS();
            create(pointEntity.getLat(), pointEntity.getLon(), pointEntity.getAzimuth(), pointEntity.getSpeed());
            Thread.sleep(2000);
        }
    }

    private void delete(int id) {
        gpsRepository.delete(id);
    }

    private void update(int id, double lat, double lon, double azimuth, double speed) {
        GPSPointEntity point = gpsRepository.findOne(id);
        point.setLat(lat);
        point.setLon(lon);
        point.setAzimuth(azimuth);
        point.setSpeed(speed);
        gpsRepository.save(point);
    }

    private void read() {
        all = (List<GPSPointEntity>) gpsRepository.findAll();

        if (all.size() == 0) {
            log.info("NO RECORDS");
        }

        all.stream().forEach(point -> log.info(point.toString()));
    }

    private GPSPointEntity create(double lat, double lon, double azimuth, double speed) {
        GPSPointEntity point = new GPSPointEntity(lat, lon, azimuth, speed);
        return gpsRepository.save(point);
    }
}
