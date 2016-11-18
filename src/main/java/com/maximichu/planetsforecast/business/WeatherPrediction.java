package com.maximichu.planetsforecast.business;


public class WeatherPrediction {

    public void prediction(Integer dia) {

        Boolean planetasAlineados;
        Boolean estaElSol;

        // Estan los planetas alineados?
         planetasAlineados = isPlanetasAlineados();

        if (planetasAlineados) {
            // el sol esta alineado con los planetas?
            estaElSol = isSolAlineadoConPLanetas();
        } else {
            // el sol esta dentro del triangulo que forman los planetas?
            estaElSol = isSolDentroDelTriangulo();
        }

        if (planetasAlineados) {
            if (estaElSol) {
                // CLIMA SECO
            } else {
                // CLIMA OPTIMO
            }
        } else if(estaElSol) {
            // CLIMA LLUVIA
        }
    }

    private Boolean isPlanetasAlineados() {
        return Boolean.TRUE;
    }

    private Boolean isSolAlineadoConPLanetas() {
        return Boolean.TRUE;
    }

    private Boolean isSolDentroDelTriangulo() {
        return Boolean.TRUE;
    }

}
