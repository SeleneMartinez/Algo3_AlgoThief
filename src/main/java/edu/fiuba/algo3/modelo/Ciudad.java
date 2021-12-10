package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

public class Ciudad {
    String nombre;
    List<Ciudad> ciudadesConectadas = new ArrayList<Ciudad>();
    List<IEdificio> edificiosEnCiudad = new ArrayList<IEdificio>(); // lista que contiene los 3 edificios en la cuidad

    public Ciudad(String nombre){
        this.nombre = nombre;
    }

    public String darNombre(){
        return nombre;
    }

    public void agregarConexion(Ciudad ciudad) {
        ciudadesConectadas.add(ciudad);
    }

    public void agregarEdificio(IEdificio edificio) {
        edificiosEnCiudad.add(edificio);
    }

    public List<Ciudad> devolverCiudadesConectadas(){
        return ciudadesConectadas;
    }

    public List<IEdificio> devolverEdificios(){
        return edificiosEnCiudad;
    }

}
