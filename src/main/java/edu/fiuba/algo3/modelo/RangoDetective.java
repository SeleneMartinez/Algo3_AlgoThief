package edu.fiuba.algo3.modelo;

public class RangoDetective implements Rango{

    private int velocidad = 1100;

    public boolean esNovato() {
        return false;
    }
    public boolean esDetective(){return true;}
    public boolean esInvestigador(){ return false;}
    public boolean esSargento(){ return false;}

    public int tiempoDeViaje(Ciudad ciudadOrigen, Ciudad ciudadDestino) {
        return (ciudadOrigen.distanciaA(ciudadDestino) / velocidad);
    }
}