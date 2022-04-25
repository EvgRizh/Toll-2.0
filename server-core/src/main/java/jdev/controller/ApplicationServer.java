package jdev.controller;

import java.util.List;
import java.util.Map;

import jdev.GPSPointEntity;
import jdev.Service.GPSSimService;
import jdev.UserEntity;
import jdev.dao.repo.GPSPointRepository;
import jdev.dao.repo.UserRepository;
import jdev.service.GetGPSService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.metamodel.Metamodel;

/**
 * Created by jenia on 17.03.22.
 */
@SpringBootApplication
@EnableJpaRepositories("jdev.dao")
@EntityScan(basePackageClasses = {jdev.UserEntity.class, jdev.GPSPointEntity.class})
public class ApplicationServer implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(ApplicationServer.class);
    private List<UserEntity> allUser;
    private  List<GPSPointEntity> allPoint;

    @Autowired
    private GetGPSService getGPSService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private GPSPointRepository gpsPointRepository;

    @Autowired
    private UserEntity userEntity;


    @Bean
    public UserEntity userEntity() {
        return new UserEntity();
    }

    @Bean
    public GPSSimService gpsSimService() {
        return new GPSSimService();
    }

    @Bean
    public GetGPSService getGPSService() {
        return  new GetGPSService();
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

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(ApplicationServer.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        while (true) {
            GPSPointEntity point;
            point = getGPSService.readGPS();
            createPoint(point);
            Thread.sleep(2000);
        }
    }

    private void deleteUser(int id) {
        userRepository.delete(id);
    }

    private void deletePoint(int id) {
        gpsPointRepository.delete(id);
    }

    private void updateUser(int id, String name) {
        UserEntity user = userRepository.findOne(id);
        user.setName(name);
        userRepository.save(user);
    }

    private void updatePoint(int id, GPSPointEntity point) {
        GPSPointEntity  gpsPointEntity = gpsPointRepository.findOne(id);
        gpsPointEntity.setLat(point.getLat());
        gpsPointEntity.setLon(point.getLon());
        gpsPointEntity.setAzimuth(point.getAzimuth());
        gpsPointEntity.setSpeed(point.getSpeed());
        gpsPointRepository.save(gpsPointEntity);
    }

    private void readUser() {
        allUser = (List<UserEntity>) userRepository.findAll();

        if (allUser.size() == 0) {
            log.info("NO RECORDS");
        }

        allUser.stream().forEach(user -> log.info(user.toString()));
    }

    private void readPoint() {
        allPoint = (List<GPSPointEntity>) gpsPointRepository.findAll();

        if (allPoint.size() == 0) {
            log.info("NO RECORDS");
        }

        allPoint.stream().forEach(point -> log.info(point.toString()));
    }

    private UserEntity createUser(String name) {
        UserEntity user = new UserEntity();
        user.setName(name);
        return userRepository.save(user);
    }

    public GPSPointEntity createPoint(GPSPointEntity point) {
        return gpsPointRepository.save(point);
    }
}
