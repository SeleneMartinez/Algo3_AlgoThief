package edu.fiuba.algo3.modelo;

public class RangoNovato{
    private int velocidad = 900;

    public boolean esNovato() {
        return true;
    }

    public int tiempoDeViaje(Ciudad ciudadOrigen, Ciudad ciudadDestino) {
        return (ciudadOrigen.distanciaA(ciudadDestino) / velocidad);
    }
}
















}
