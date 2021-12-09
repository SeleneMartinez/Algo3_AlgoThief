package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ArmadorMapa {

    static final int MIN_NUMERO_PAISES = 1;
    static final int MAX_NUMERO_PAISES = 30;
    int cantidadCiudadesDelLadron;
    List <Ciudad> rutaLadron = new ArrayList<Ciudad>();
    List <Ciudad> listaPaises = new ArrayList<Ciudad>();
    Ciudad ciudadActual;

    public ArmadorMapa( List <Ciudad> listaPaises, int cantidadCiudadesDelLadron ){
        this.listaPaises = listaPaises;
        this.cantidadCiudadesDelLadron = cantidadCiudadesDelLadron;
        desordenarLista();
        crearRutaLadron(); // crea la ruta principal de escape del ladron
        conectarCiudadesEnRutaLadron();
        ciudadActual = rutaLadron.get(0);
    }

    private void desordenarLista() {
        for(int posicion = MIN_NUMERO_PAISES; posicion < MAX_NUMERO_PAISES; posicion++)
            intercambiar( listaPaises, posicion, darNumeroAleatorio() );
    }

    private void intercambiar(List<Ciudad> listaPaises, int posicion, int otraPosicion){
        Ciudad auxiliar = listaPaises.get(posicion);
        listaPaises.add( posicion, listaPaises.get(otraPosicion) );
        listaPaises.add( otraPosicion, auxiliar );
    }

    private int darNumeroAleatorio(){
        Random numero = new Random();
        return ( MIN_NUMERO_PAISES + numero.nextInt( MAX_NUMERO_PAISES ) );
    }

    private void establecerConexiones( Ciudad ciudad, Ciudad otraCiudad){ // ciudad agrega a su lista de ciudades conectadas a otra ciudad
        ciudad.agregarConexion(otraCiudad);
        otraCiudad.agregarConexion(ciudad);
    }

    private void crearRutaLadron(){
        for (int i = 0; i < cantidadCiudadesDelLadron; i++){
            rutaLadron.add( listaPaises.get(0) );
            listaPaises.remove(0);
        }
    }
    
    private void conectarCiudadesEnRutaLadron() { // agrega 2 ciudades random a cada ciudad de la ruta del ladron
        for (Ciudad ciudad: rutaLadron){
            for (int i = 1; i <= 2; i++){
                Ciudad ciudadAlAzar = darCiudadAlAzar();
                establecerConexiones(ciudad, ciudadAlAzar);
            }
        }
    }

    private Ciudad darCiudadAlAzar() {
        Ciudad aux = listaPaises.get(0);
        listaPaises.remove(0);
        return aux;
    }

}
