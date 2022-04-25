package jdev;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.*;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Table(name = "COORDSNAME1")
public class GPSPointEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    int id;

    @Column(name = "LAT")
    private double lat;

    @Column(name = "LON")
    private double lon;

    @Column(name = "AZIMUTH")
    private double azimuth;

    @Column(name = "SPEED")
    private double speed;

    public GPSPointEntity(double lat, double lon, double azimuth, double speed) {
        this.lat = lat;
        this.lon = lon;
        this.azimuth = azimuth;
        this.speed = speed;
    }

    public GPSPointEntity() {
    }


    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }

    public double getAzimuth() {
        return azimuth;
    }

    public double getSpeed() {
        return speed;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public void setAzimuth(double azimuth) {
        this.azimuth = azimuth;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }


    public String toJson() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(this);
    }

    public GPSPointEntity gpsRandom() {
        double rnd = Math.random();
        double pointLat = getLat() + rnd/100;
        double pointLon = getLon() - rnd/100;
        double pointAzimuth = getAzimuth() + rnd/100;
        double pointSpeed = getSpeed() + rnd - 0.5;
        setLat(Math.ceil(pointLat*1000)/1000);
        setLon(Math.ceil(pointLon*1000)/1000);
        setAzimuth(Math.ceil(pointAzimuth*1000)/1000);
        setSpeed(Math.ceil(pointSpeed*1000)/1000);

        return null;
    }


    @Override
    public String toString() {
        return "GPSPoint{" +
                "lat=" + lat +
                ", lon=" + lon +
                ", azimuth=" + azimuth +
                ", speed=" + speed +'}';
    }
}