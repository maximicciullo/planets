package com.maximichu.planetsforecast.model;

import com.maximichu.planetsforecast.business.PositionDay;
import com.maximichu.planetsforecast.enums.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.ArrayList;

public class PredictionType implements Serializable {

    @Autowired
    private PositionDay positionDay;

    private Integer id;
    private Boolean planetasAlineados;
    private Boolean solConPlanetas;
    private Boolean solTriangulo;
    private Double perimetro;
    private ArrayList<Planet> planetas;
    private String estadoClima;
    private ArrayList<Position> posicionPlanetas;

    public PredictionType(int dia) {
        this.id = dia;
        this.planetasAlineados = Boolean.FALSE;
        this.solConPlanetas = Boolean.FALSE;
        this.solTriangulo = Boolean.FALSE;
        this.perimetro = new Double(0.00);
        this.planetas = new ArrayList<Planet>();
        this.estadoClima = Clima.NO_DEFINIDO.getClima();

        if (planetas == null || planetas.isEmpty()) {
            cargarPlanetas();
        }

        cargarPosiciones(dia);

    }

    private void cargarPlanetas() {
        Planet ferengi = new Planet(NombrePlaneta.FERENGI, DistanciaAlSol.FERENGI, VelocidadAngular.FERENGI, SentidoRotacion.FERENGI);
        Planet betasoide = new Planet(NombrePlaneta.BETASOIDE, DistanciaAlSol.BETASOIDE, VelocidadAngular.BETASOIDE, SentidoRotacion.BETASOIDE);
        Planet vulcano = new Planet(NombrePlaneta.VULCANO, DistanciaAlSol.VULCANO, VelocidadAngular.VULCANO, SentidoRotacion.VULCANO);

        planetas = new ArrayList<Planet>();
        planetas.add(ferengi);
        planetas.add(betasoide);
        planetas.add(vulcano);
    }

    private void cargarPosiciones(int dia) {

        Position posicionFerengi = positionDay.getPosition(planetas.get(0), dia);
        Position posicionBetasoide = positionDay.getPosition(planetas.get(1), dia);
        Position posicionVulcano = positionDay.getPosition(planetas.get(2), dia);

        posicionPlanetas = new ArrayList<Position>();
        posicionPlanetas.add(posicionFerengi);
        posicionPlanetas.add(posicionBetasoide);
        posicionPlanetas.add(posicionVulcano);
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

    public void setEstadoClima(Clima estadoClima) {
        this.estadoClima = estadoClima.getClima();
    }

    public PositionDay getPositionDay() {
        return positionDay;
    }

    public void setPositionDay(PositionDay positionDay) {
        this.positionDay = positionDay;
    }

    public ArrayList<Position> getPosicionPlanetas() {
        return posicionPlanetas;
    }

    public void setPosicionPlanetas(ArrayList<Position> posicionPlanetas) {
        this.posicionPlanetas = posicionPlanetas;
    }

    public Boolean getSolTriangulo() {
        return solTriangulo;
    }

    public void setSolTriangulo(Boolean solTriangulo) {
        this.solTriangulo = solTriangulo;
    }
}
