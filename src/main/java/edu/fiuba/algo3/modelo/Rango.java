package edu.fiuba.algo3.modelo;

public interface Rango {
    public abstract int tiempoDeViaje(Ciudad ciudadOrigen, Ciudad ciudadDestino);
    public abstract boolean esNovato();
    public abstract boolean esDetective();
    public abstract boolean esInvestigador();
    public abstract boolean esSargento();
}
