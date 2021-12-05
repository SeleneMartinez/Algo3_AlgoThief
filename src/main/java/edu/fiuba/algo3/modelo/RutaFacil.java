package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RutaFacil implements IRutaDeEscape{
    List<Ciudad> ciudadesDeLaRuta = new ArrayList<Ciudad>();
    List<Ciudad> ciudadesConectadas = new ArrayList<Ciudad>();
    public void agregarCiudadEnLaRuta(Ciudad ciudad) {
        {
            ciudadesDeLaRuta.add(ciudad);
            ciudadesConectadas.addAll(ciudad.devolverCiudadesConectadas());
            ciudadesDeLaRuta.add(ciudadesConectadas.get(0));
            ciudadesDeLaRuta.add(ciudadesConectadas.get(1));
            ciudadesDeLaRuta.add(ciudadesConectadas.get(2));



        }
    }
    Iterator<Ciudad> iteradorCiudades= ciudadesDeLaRuta.iterator();
    private Ciudad proximaCiudad = iteradorCiudades.next();
    public Ciudad devolverProximaCiudad (){return this.proximaCiudad; };
}
