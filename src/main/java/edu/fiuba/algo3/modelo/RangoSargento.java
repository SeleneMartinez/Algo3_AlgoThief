package edu.fiuba.algo3.modelo;

public class RangoSargento {
    private int velocidad = 1500;

    public boolean esNovato() {
        return true;
    }

    public int tiempoDeViaje(Ciudad ciudadOrigen, Ciudad ciudadDestino) {
        return (ciudadOrigen.distanciaA(ciudadDestino) / velocidad);
    }
}