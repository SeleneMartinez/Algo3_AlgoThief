package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

    public void agregarPista(Pista pistaLadron){
        //int random = (new Random()).nextInt(edificiosEnCiudad.size());
        int random = (new Random()).nextInt(2);
        edificiosEnCiudad.remove(random);
        //edificiosEnCiudad.add(new Banco(pistaLadron));
        edificiosEnCiudad.add(random, new Banco(pistaLadron));
    }
    public List<Ciudad> getConexiones(){
        return this.ciudadesConectadas;
    }
    public String darNombre(){
        return nombre;
    }
    public void agregarConexion(Ciudad ciudad) {

        if(ciudadesConectadas.size()<3) {

            ciudadesConectadas.add(ciudad);
        }
    }
    public void eliminarConexiones() {
        ciudadesConectadas.clear();
    }

    public void agregarCiudadAnterior(Ciudad ciudadAnterior) {
        ciudadesConectadas.add(ciudadAnterior);
        this.ciudadAnterior = ciudadAnterior;
    }
    public void agregarEdificio(IEdificio edificio) {
        edificiosEnCiudad.add(edificio);
    }
    public void eliminarEdificios() {
        edificiosEnCiudad.clear();
    }

    public List<Ciudad> devolverCiudadesConectadas(){
        return ciudadesConectadas;
    }



    public Ciudad devolverCiudadAnterior() { 
        return ciudadAnterior;
    }

    public List<IEdificio> devolverEdificios(){
        return edificiosEnCiudad;
    }
    public int obtenerDistanciaA(Ciudad destino){
        return this.ubicacion.calcularDistancia(destino.ubicacion);
    }

    public void agregarPistaLadron(){
        
    }


}
