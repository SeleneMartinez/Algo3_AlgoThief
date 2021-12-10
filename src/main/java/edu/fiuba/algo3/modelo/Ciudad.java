package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

public class Ciudad {
    String nombre;
    Ubicacion ubicacion;
    ConectorCiudades conector;
    List<Ciudad> ciudadesConectadas = new ArrayList<Ciudad>();
    List<IEdificio> edificiosEnCiudad = new ArrayList<IEdificio>(); // lista que contiene los 3 edificios en la cuidad

    public Ciudad(String nombre, Ubicacion ubicacion, ConectorCiudades conector){
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.conector = conector;
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



    public List<Ciudad> devolverCiudadesConectadasPrimeraVez() {
        {
            this.ciudadesConectadas = conector.agregarConexionesPrimeraVez(this);
            return ciudadesConectadas;
        }
    }

    public List<Ciudad> devolverCiudadesConectadas(){
        {
            this.ciudadesConectadas = conector.agregarConexiones(this);
            return ciudadesConectadas;
        }

    }

    public List<IEdificio> devolverEdificios(){
        return edificiosEnCiudad;
    }

    public int obtenerDistanciaA(Ciudad destino){
        return this.ubicacion.calcularDistancia(destino.ubicacion);
    }

}
