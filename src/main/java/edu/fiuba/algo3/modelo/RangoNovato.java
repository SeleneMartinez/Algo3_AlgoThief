package edu.fiuba.algo3.modelo;

public class RangoNovato implements Rango{
    private int velocidad = 900;

    public boolean esNovato() {
        return true;
    }
    public boolean esDetective(){ return false;}
    public boolean esInvestigador(){ return false;}
    public boolean esSargento(){ return false;}

    public int tiempoDeViaje(Ciudad ciudadOrigen, Ciudad ciudadDestino) {
        return (int)((ciudadOrigen.distanciaA(ciudadDestino) / velocidad));
    }
}
















}
