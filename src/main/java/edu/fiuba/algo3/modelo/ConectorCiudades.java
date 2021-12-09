package edu.fiuba.algo3.modelo;

import java.util.List;
import java.util.Random;

public class ConectorCiudades {

    static final int MIN_NUMERO_PAISES = 1;
    static final int MAX_NUMERO_PAISES = 30;
    List<Ciudad> ciudadesSinConectar;
    
    public ConectorCiudades(List<Ciudad> ciudadesSinConectar){
        this.ciudadesSinConectar = ciudadesSinConectar;
        desordenarLista();
    }

    private Ciudad darCiudadAlAzar() {
        Ciudad aux = ciudadesSinConectar.get(0);
        ciudadesSinConectar.remove(0);
        return aux;
    }

    private void desordenarLista() {
        for(int posicion = MIN_NUMERO_PAISES; posicion < MAX_NUMERO_PAISES; posicion++)
            intercambiar( ciudadesSinConectar, posicion, darNumeroAleatorio() );
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

    public void agrarConexiones(Ciudad ciudad){
        for (int i = 1; i <= 2; i++){
            Ciudad ciudadAlAzar = darCiudadAlAzar();
            establecerConexiones(ciudad, ciudadAlAzar);
        }
    }

    private void establecerConexiones( Ciudad ciudad, Ciudad otraCiudad){ // ciudad agrega a su lista de ciudades conectadas a otra ciudad
        ciudad.agregarConexion(otraCiudad);
        otraCiudad.agregarConexion(ciudad);
    }
}
