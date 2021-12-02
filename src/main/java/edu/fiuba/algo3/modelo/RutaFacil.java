package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

public class RutaFacil implements RutaDeEscape{
    List<Ciudad> ciudadesDeLaRuta = new ArrayList<Ciudad>();
    public void agregarCiudadEnLaRuta(Ciudad ciudad) {
        ciudadesDeLaRuta.add(ciudad);
    }
    private Ciudad proximaCiudad = ciudadesDeLaRuta.get(0);
    public Ciudad devolverProximaCiudad (){return this.proximaCiudad; this.ciudadesDeLaRuta.remove(0);};
}
