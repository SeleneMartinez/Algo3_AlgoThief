package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RutaFacil implements RutaDeEscape{
    List<Ciudad> ciudadesDeLaRuta = new ArrayList<Ciudad>();
    public void agregarCiudadEnLaRuta(Ciudad ciudad) {
        ciudadesDeLaRuta.add(ciudad);
    }
    Iterator<Ciudad> iteradorCiudades= ciudadesDeLaRuta.iterator();
    private Ciudad proximaCiudad = iteradorCiudades.next();
    public Ciudad devolverProximaCiudad (){return this.proximaCiudad; };
}
