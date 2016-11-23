package com.maximichu.planetsforecast.model;

import java.io.Serializable;

public class Position implements Serializable {

    private Long id;

    private Double x;

    private Double y;

    private Double velocidadAngular;


    public Position(Double velocidadAngular, Double x, Double y) {
        this.velocidadAngular = velocidadAngular;
        this.x = x;
        this.y = y;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public Double getVelocidadAngular() {
        return velocidadAngular;
    }

    public void setVelocidadAngular(Double velocidadAngular) {
        this.velocidadAngular = velocidadAngular;
    }
}
