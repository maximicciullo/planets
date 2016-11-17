package com.maximichu.planetsforecast.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Planet implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private Double distance;

    private Double speed;

    private Integer clockwise;

    private Position position;


    public Planet(String name, Double distance, Double speed, Integer clockwise) {
        this.name = name;
        this.distance = distance;
        this.speed = speed;
        this.clockwise = clockwise;
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
