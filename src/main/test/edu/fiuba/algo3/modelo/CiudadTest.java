package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

public class CiudadTest {

    @Test
    public void conexionVacia() {
        List<Ciudad> ciudades = new ArrayList<Ciudad>();
        ciudades = crearCiudades();
        for (Ciudad ciudad : ciudades){
            assertEquals(ciudad.devolverCiudadesConectadas().size(), 0);
        }
    }

    @Test
    public void ciudadesConectadas() {
        List<Ciudad> ciudades = new ArrayList<Ciudad>();
        ciudades = crearCiudades();
        ciudades.get(0).agregarConexion( ciudades.get(1) );
        ciudades.get(0).agregarConexion( ciudades.get(2) );
        ciudades.get(1).agregarConexion( ciudades.get(4) );
        assertEquals(ciudades.get(0).devolverCiudadesConectadas().size(), 2);
        assertEquals(ciudades.get(1).devolverCiudadesConectadas().size(), 1);
        assertEquals(ciudades.get(0).devolverCiudadesConectadas().get(0).darNombre(), "Montreal" );
        assertEquals(ciudades.get(0).devolverCiudadesConectadas().get(1).darNombre(), "Berlin" );
        assertEquals(ciudades.get(1).devolverCiudadesConectadas().get(0).darNombre(), "Moscu" );
    }

    public List<Ciudad> crearCiudades() {
        List<Ciudad> ciudades = new ArrayList<Ciudad>();
        Ciudad buenosAires = new Ciudad("Argentina");
        Ciudad montreal = new Ciudad("Montreal");
        Ciudad berlin = new Ciudad("Berlin");
        Ciudad sidney = new Ciudad("Sidney");
        Ciudad moscu = new Ciudad("Moscu");
        ciudades.add(buenosAires);
        ciudades.add(montreal);
        ciudades.add(berlin);
        ciudades.add(sidney);
        ciudades.add(moscu);
        return ciudades;
    }


}
