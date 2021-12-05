package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

public class Ciudad {
    String nombre;
    Ciudad ciudadAnterior;
    List<Ciudad> ciudadesConectadas = new ArrayList<Ciudad>();
    Ubicacion ubicacion;
    List<IEdificio> edificiosEnCiudad = new ArrayList<IEdificio>(); // lista que contiene los 3 edificios en la cuidad

    public Ciudad(String nombre, Ubicacion ubicacion){
        this.nombre = nombre;
        this.ubicacion = ubicacion;
    }

    public String darNombre(){
        return nombre;
    }

    public void agregarConexion(Ciudad ciudad) {
        ciudadesConectadas.add(ciudad);
    }

    public int obtenerDistanciaA(Ciudad destino){
        return this.ubicacion.calcularDistancia(destino.ubicacion);
    }
    

    /*public void agregarEdificio(Edificio edificio) {
        edificiosEnCiudad.add(edificio);
    }

    public List<Ciudad> devolverCiudadesConectadas(){
        return ciudadesConectadas;
    }

    public Ciudad devolverCiudadAnterior() { 
        return ciudadAnterior;
    }

    public List<Edificio> devolverEdificios(){
        return edificiosEnCiudad;
    }

}
