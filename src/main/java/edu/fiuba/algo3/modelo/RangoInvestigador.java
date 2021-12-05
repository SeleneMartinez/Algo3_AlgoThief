package edu.fiuba.algo3.modelo;

public class RangoInvestigador implements IRango{
    private int velocidad = 1300;

    public boolean esNovato(){
        return false;
    }
    public boolean esDetective(){ return false; }
    public boolean esInvestigador(){ return true; }
    public boolean esSargento(){ return false; }

    public int tiempoDeViaje(Ciudad ciudadOrigen, Ciudad ciudadDestino) {
        return (ciudadOrigen.obtenerDistanciaA(ciudadDestino) / velocidad);
    }
    public IRango obtenerRango(int casosResueltos)
    {
        IRango output = this;
        if(casosResueltos >= 15)
        {
            output = new RangoSargento();
        }
        return output;
    }
}
