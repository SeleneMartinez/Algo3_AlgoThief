package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

public class Ciudad {
    String nombre;
    Ciudad ciudadAnterior;
    List<Ciudad> ciudadesConectadas = new ArrayList<Ciudad>();
    List<Edificio> edificiosEnCiudad = new ArrayList<Edificio>(); // lista que contiene los 3 edificios en la cuidad

    public Ciudad(String nombre){
        this.nombre = nombre;
    }

    public String darNombre(){
        return nombre;
    }

    public void agregarConexion(Ciudad ciudad) {
        ciudadesConectadas.add(ciudad);
    }

    public void agregarCiudadAnterior(Ciudad ciudadAnterior) {
        ciudadesConectadas.add(ciudadAnterior);
        this.ciudadAnterior = ciudadAnterior;
    }

    public void agregarEdificio(Edificio edificio) {
        edificiosEnCiudad.add(edificio);
    }

    public List<Ciudad> devolverCiudadesConectadas(){
        return ciudadesConectadas;
    }

    public Ciudad devolverCiudadAnterior() { 
        return ciudadAnterior;}
    }

    public List<Edificio> devolverEdificios(){
        return edificiosEnCiudad;
    }

}
