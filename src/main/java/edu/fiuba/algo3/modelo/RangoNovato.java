package edu.fiuba.algo3.modelo;

public class RangoNovato implements IRango{
    private double velocidad = 900;

    public boolean esNovato() {
        return true;
    }
    public boolean esDetective(){ return false;}
    public boolean esInvestigador(){ return false;}
    public boolean esSargento(){ return false;}

    public int tiempoDeViaje(Ciudad ciudadOrigen, Ciudad ciudadDestino) {
        return (int) Math.ceil(((double) ciudadOrigen.obtenerDistanciaA(ciudadDestino) / velocidad));
    }

    public IRango obtenerRango(int casosResueltos)
    {
        IRango output = this;
        if(casosResueltos >= 5)
        {
            output = new RangoDetective();
        }
        return output;
    }
}

















