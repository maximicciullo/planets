package com.maximichu.planetsforecast.model;

import java.util.LinkedList;

import javax.persistence.Entity;

@Entity
public class PredictionType {

    private Boolean planetasAlineados;
    private Boolean solConPlanetas;
    private Double perimetro;
    private LinkedList<Planet> planetas;
    private String estadoClima;

    public Boolean getPlanetasAlineados() {
        return planetasAlineados;
    }

    public void setPlanetasAlineados(Boolean planetasAlineados) {
        this.planetasAlineados = planetasAlineados;
    }

    public Boolean getSolConPlanetas() {
        return solConPlanetas;
    }

    public void setSolConPlanetas(Boolean solConPlanetas) {
        this.solConPlanetas = solConPlanetas;
    }

    public Double getPerimetro() {
        return perimetro;
    }

    public void setPerimetro(Double perimetro) {
        this.perimetro = perimetro;
    }

    public LinkedList<Planet> getPlanetas() {
        return planetas;
    }

    public void setPlanetas(LinkedList<Planet> planetas) {
        this.planetas = planetas;
    }

    public String getEstadoClima() {
        return estadoClima;
    }

    public void setEstadoClima(String estadoClima) {
        this.estadoClima = estadoClima;
    }
}
