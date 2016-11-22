package com.maximichu.planetsforecast.model;

import com.maximichu.planetsforecast.utils.Constantes;

import java.util.ArrayList;
import java.util.LinkedList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PredictionType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Boolean planetasAlineados;
    private Boolean solConPlanetas;
    private Double perimetro;
    private ArrayList<Planet> planetas;
    private String estadoClima;


    public PredictionType(int dia) {
        this.id = dia;
        this.planetasAlineados = Boolean.FALSE;
        this.solConPlanetas = Boolean.FALSE;
        this.perimetro = new Double(0.00);
        this.planetas = new ArrayList<Planet>();
        this.estadoClima = Constantes.CLIMA_INICIAL;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public ArrayList<Planet> getPlanetas() {
        return planetas;
    }

    public void setPlanetas(ArrayList<Planet> planetas) {
        this.planetas = planetas;
    }

    public String getEstadoClima() {
        return estadoClima;
    }

    public void setEstadoClima(String estadoClima) {
        this.estadoClima = estadoClima;
    }
}
