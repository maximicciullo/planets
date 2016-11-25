package com.maximichu.planetsforecast.business;


import com.maximichu.planetsforecast.enums.Clima;
import com.maximichu.planetsforecast.model.PredictionType;
import org.springframework.stereotype.Component;

@Component
public class WeatherPrediction {

    public static Double SOL_POS_X = 0.0;
    public static Double SOL_POS_Y = 0.0;
    public static Float  LAMDA_TOLERANCIA = new Float(20);


    /**
     * Segun la posicion del los planetas y el sol, se puede saber
     * que tipo de clima va a haber para el dia seteado en el
     * parametro de entrada.
     *
     * CLIMA SECO: Tres planetas alineados entre si y con el sol.
     *
     * CLIMA HUMEDO: Tres planetas forman un triangulo y el sol
     * se encuentra dentro del mismo.
     *
     * CLIMA OPTIMO: Planetas alineados entre si pero no con el sol.
     *
     * @param predictionType
     * @return
     */
    public PredictionType prediction(PredictionType predictionType) {

        // Estan los planetas alineados?
         predictionType.setPlanetasAlineados(isPlanetasAlineados(predictionType));

        if (predictionType.getPlanetasAlineados()) {
            // el sol esta alineado con los planetas?
            predictionType.setSolConPlanetas(isSolAlineadoConPLanetas(predictionType));
        } else {
            // el sol esta dentro del triangulo que forman los planetas?
            predictionType.setSolTriangulo(isSolDentroDelTriangulo(predictionType));
        }

        if (predictionType.getPlanetasAlineados()) {
            if (predictionType.getSolConPlanetas()) {
                predictionType.setEstadoClima(Clima.SECO);
            } else {
                predictionType.setEstadoClima(Clima.OPTIMO);
            }
        } else if(predictionType.getSolTriangulo()) {
            predictionType.setEstadoClima(Clima.HUMEDO);
            predictionType.setPerimetro(obtenerPerimetroTriangulo(predictionType));
        }

        return predictionType;
    }

    private Boolean isPlanetasAlineados(PredictionType predictionType) {
        Double x0 = predictionType.getPosicionPlanetas().get(0).getX();
        Double y0 = predictionType.getPosicionPlanetas().get(0).getY();

        Double x1 = predictionType.getPosicionPlanetas().get(1).getX();
        Double y1 = predictionType.getPosicionPlanetas().get(1).getY();

        Double x2 = predictionType.getPosicionPlanetas().get(2).getX();
        Double y2 = predictionType.getPosicionPlanetas().get(2).getY();

        return condicionAlineados(x0, y0, x1, y1, x2, y2);
    }

    private Boolean condicionAlineados(Double x0, Double y0, Double x1, Double y1, Double x2, Double y2) {
        Double yProyectada = (x0 - x1) * (y2 - y1) / (x2 - x1) + y1;
        Boolean planetasAlineados = Math.abs(yProyectada - y0) <= LAMDA_TOLERANCIA;
        return planetasAlineados;
    }

    private Boolean isSolAlineadoConPLanetas(PredictionType predictionType) {
        Double solx = SOL_POS_X;
        Double soly = SOL_POS_Y;

        Double x1 = predictionType.getPosicionPlanetas().get(1).getX();
        Double y1 = predictionType.getPosicionPlanetas().get(1).getY();

        Double x2 = predictionType.getPosicionPlanetas().get(2).getX();
        Double y2 = predictionType.getPosicionPlanetas().get(2).getY();

        return condicionAlineados(solx, soly, x1, y1, x2, y2);
    }

    private Boolean isSolDentroDelTriangulo(PredictionType predictionType) {
        Double x0 = predictionType.getPosicionPlanetas().get(0).getX();
        Double y0 = predictionType.getPosicionPlanetas().get(0).getY();

        Double x1 = predictionType.getPosicionPlanetas().get(1).getX();
        Double y1 = predictionType.getPosicionPlanetas().get(1).getY();

        Double x2 = predictionType.getPosicionPlanetas().get(2).getX();
        Double y2 = predictionType.getPosicionPlanetas().get(2).getY();

        Double solx = SOL_POS_X;
        Double soly = SOL_POS_Y;

        Boolean igualLadoAB = igualLado(solx, soly, x0, y0, x1, y1);
        Boolean igualLadoBC = igualLado(solx, soly, x1, y1, x2, y2);
        Boolean igualLadoCA = igualLado(solx, soly, x2, y2, x0, y0);

        return ((igualLadoAB == igualLadoBC) && (igualLadoBC == igualLadoCA));
    }

    private Boolean igualLado(Double x, Double y, Double x0, Double y0, Double x1, Double y1) {
        return ( (x - x1) * (y0 - y1) - (x0 - x1) * (y - y1) ) < 0.0;
    }

    private Double obtenerPerimetroTriangulo(PredictionType predictionType) {
        Double x0 = predictionType.getPosicionPlanetas().get(0).getX();
        Double y0 = predictionType.getPosicionPlanetas().get(0).getY();

        Double x1 = predictionType.getPosicionPlanetas().get(1).getX();
        Double y1 = predictionType.getPosicionPlanetas().get(1).getY();

        Double x2 = predictionType.getPosicionPlanetas().get(2).getX();
        Double y2 = predictionType.getPosicionPlanetas().get(2).getY();

        Double ab = Math.sqrt(Math.pow((x1 - x0), 2) + Math.pow((y1 - y0), 2));
        Double bc = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
        Double ca = Math.sqrt(Math.pow((x2 - x0), 2) + Math.pow((y2 - y0), 2));

        return ab + bc + ca;
    }

}
