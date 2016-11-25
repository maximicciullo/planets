package com.maximichu.planetsforecast.model;

import com.maximichu.planetsforecast.enums.DistanciaAlSol;
import com.maximichu.planetsforecast.enums.NombrePlaneta;
import com.maximichu.planetsforecast.enums.SentidoRotacion;
import com.maximichu.planetsforecast.enums.VelocidadAngular;

import java.io.Serializable;

public class Planet implements Serializable {

    private Long id;

    private String name;

    private Double distance;

    private Double speed;

    private Integer clockwise;

    private Position position;


    public Planet(NombrePlaneta planet, DistanciaAlSol distance, VelocidadAngular speed, SentidoRotacion clockwise) {
        this.name = planet.name();
        this.distance = distance.getDistancia();
        this.speed = speed.getVelocidad();
        this.clockwise = clockwise.getSentidoRotacion();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public Double getVelocity() {
        return speed;
    }

    public void setVelocity(Double speed) {
        this.speed = speed;
    }

    public Integer getClockwise() {
        return clockwise;
    }

    public void setClockwise(Integer clockwise) {
        this.clockwise = clockwise;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

}
