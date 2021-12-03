package edu.fiuba.algo3.modelo;

public class RangoInvestigador{
    private int velocidad = 1300;

    public boolean esInvestigador() {
        return true;
    }

    public int tiempoDeViaje(Ciudad ciudadOrigen, Ciudad ciudadDestino) {
        return (ciudadOrigen.distanciaA(ciudadDestino) / velocidad);
    }
}
