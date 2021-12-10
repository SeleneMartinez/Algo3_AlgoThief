package edu.fiuba.algo3.modelo;

public class RangoDetective implements IRango{

    private double velocidad = 1100;

    public boolean esNovato() {
        return false;
    }
    public boolean esDetective(){return true;}
    public boolean esInvestigador(){ return false;}
    public boolean esSargento(){ return false;}

    public int tiempoDeViaje(Ciudad ciudadOrigen, Ciudad ciudadDestino) {
        return (int) Math.ceil(((double) ciudadOrigen.obtenerDistanciaA(ciudadDestino) / velocidad));
    }

    public IRango obtenerRango(int casosResueltos)
    {
        IRango output = this;
        if(casosResueltos >= 10)
        {
            output = new RangoInvestigador();
        }
        return output;
    }
}