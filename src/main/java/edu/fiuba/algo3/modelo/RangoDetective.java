package edu.fiuba.algo3.modelo;

public class RangoDetective{

    private int velocidad = 1100;

    public boolean esDetective(){
        return true;
    }

    public int tiempoDeViaje(Ciudad ciudadOrigen, Ciudad ciudadDestino) {
        return (ciudadOrigen.distanciaA(ciudadDestino) / velocidad);
    }
}