package edu.fiuba.algo3.modelo;

import java.util.List;
import java.util.Random;

public class ConectorCiudades {

    int cantidadDePaises;
    List<Ciudad> ciudadesSinConectar;

    
    public void RecibeSinConectar(List<Ciudad> ciudadesSinConectar){
        cantidadDePaises = ciudadesSinConectar.size();
        this.ciudadesSinConectar = ciudadesSinConectar;
        desordenarLista();
    }

    private Ciudad darCiudadAlAzar() {
        Ciudad aux = ciudadesSinConectar.get(0);
        ciudadesSinConectar.remove(0);
        return aux;
    }

    private void desordenarLista() {
        for(int posicion = 0; posicion < cantidadDePaises; posicion++)
            intercambiar( ciudadesSinConectar, posicion, darNumeroAleatorio() );
    }

    private void intercambiar(List<Ciudad> listaPaises, int posicion, int otraPosicion){
        Ciudad auxiliar = listaPaises.get(posicion);
        listaPaises.add( posicion, listaPaises.get(otraPosicion) );
        listaPaises.add( otraPosicion, auxiliar );
    }

    private int darNumeroAleatorio(){
        Random numero = new Random();
        return ( 0 + numero.nextInt( cantidadDePaises ) );
    }

    public List<Ciudad> agregarConexiones(Ciudad ciudad){
        ciudadesSinConectar.remove(ciudad);
        for (int i = 1; i <= 2; i++){
            Ciudad ciudadAlAzar = darCiudadAlAzar();
            ciudadesSinConectar.add(ciudadAlAzar);
            ciudadesSinConectar.remove(ciudadAlAzar);
        }
        return ciudadesSinConectar;
    }
    public List<Ciudad> agregarConexionesPrimeraVez(Ciudad ciudad){
        ciudadesSinConectar.remove(ciudad);
        for (int i = 1; i <= 3; i++){
            Ciudad ciudadAlAzar = darCiudadAlAzar();
            ciudadesSinConectar.add(ciudadAlAzar);
            ciudadesSinConectar.remove(ciudadAlAzar);
        }
        return ciudadesSinConectar;
    }



}
