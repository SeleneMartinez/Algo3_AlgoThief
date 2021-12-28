package edu.fiuba.algo3.modelo;

import java.util.HashMap;
import java.util.List;

public interface IRutaDeEscape {
    Ciudad devolverProximaCiudad();
    void crearRuta(List<Ciudad> ciudades);
    void agregarPistas(List<Pista> pistasLadron, HashMap<String, List<Pista>> pistasPorCiudad, Ladron ladron);
    Ciudad devolverCiudadActual();
    boolean ciudadEnLaRuta(Ciudad ciudad);
}
