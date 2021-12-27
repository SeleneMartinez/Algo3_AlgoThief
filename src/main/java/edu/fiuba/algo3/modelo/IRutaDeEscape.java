package edu.fiuba.algo3.modelo;

import java.util.List;

public interface IRutaDeEscape {
    Ciudad devolverProximaCiudad();
    void crearRuta(List<Ciudad> ciudades);
}
