package edu.fiuba.algo3.modelo;

public class RangoSargento implements IRango{
    private int velocidad = 1500;

    public boolean esNovato() {
        return false;
    }
    public boolean esDetective(){ return false; }
    public boolean esInvestigador(){ return false; }
    public boolean esSargento(){ return true; }

    public int tiempoDeViaje(Ciudad ciudadOrigen, Ciudad ciudadDestino) {
        return (ciudadOrigen.distanciaA(ciudadDestino) / velocidad);
    }

    public IRango obtenerRango(int casosResueltos)
    {
        return this;
    }
}