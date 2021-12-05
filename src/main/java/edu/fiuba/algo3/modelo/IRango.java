package edu.fiuba.algo3.modelo;

public interface IRango {
    public abstract int tiempoDeViaje(Ciudad ciudadOrigen, Ciudad ciudadDestino);
    public abstract boolean esNovato();
    public abstract boolean esDetective();
    public abstract boolean esInvestigador();
    public abstract boolean esSargento();
    public IRango obtenerRango(int casosResueltos);
}
