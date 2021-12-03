package edu.fiuba.algo3.modelo;

public class RangoInvestigador implements Rango{
    private int velocidad = 1300;

    public boolean esNovato(){
        return false;
    }
    public boolean esDetective(){ return false; }
    public boolean esInvestigador(){ return true; }
    public boolean esSargento(){ return false; }

    public int tiempoDeViaje(Ciudad ciudadOrigen, Ciudad ciudadDestino) {
        return (ciudadOrigen.distanciaA(ciudadDestino) / velocidad);
    }
}
