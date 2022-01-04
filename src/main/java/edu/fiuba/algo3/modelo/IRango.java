package edu.fiuba.algo3.modelo;

import java.util.HashMap;
import java.util.List;

public interface IRango {
    public abstract int tiempoDeViaje(Ciudad ciudadOrigen, Ciudad ciudadDestino);
    public abstract boolean esNovato();
    public abstract boolean esDetective();
    public abstract boolean esInvestigador();
    public abstract boolean esSargento();
    public IRango obtenerRango(int casosResueltos);
    public HashMap<String, List<Pista>> obtenerPistaPorRango();
    public IRutaDeEscape obtenerRutaDeEscapeSegunRango();
}
