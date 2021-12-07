package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class RutaDificil implements IRutaDeEscape{
    List<Ciudad> ciudadesDeLaRuta = new ArrayList<Ciudad>();
    List<Ciudad> ciudadesConectadas = new ArrayList<Ciudad>();
    Ciudad proximaCiudad;
    Ciudad ciudadActual;
    Random rand = new Random();

    public RutaDificil (Ciudad ciudad){
        this.ciudadActual = ciudad;
    }

    public RutaDificil (){
        this.agregarCiudadesEnLaRuta();
    }

    public void agregarCiudadesEnLaRuta() {

        int x = 1;
        ciudadesDeLaRuta.add(ciudadActual);
        while (x <= 4)
        {
            ciudadesConectadas.addAll(ciudadActual.devolverCiudadesConectadas());
            int int_random = rand.nextInt(ciudadesConectadas.size());
            ciudadesDeLaRuta.add(ciudadesConectadas.get(int_random));
            x++;
            ciudadActual = ciudadesDeLaRuta.get(x);

        }
    }
    Iterator<Ciudad> iteradorCiudades= ciudadesDeLaRuta.iterator();
    private void recorrerCiudades (){ proximaCiudad = iteradorCiudades.next();}
    public Ciudad devolverProximaCiudad (){
        {
            this.recorrerCiudades ();
            return this.proximaCiudad;
        }
    }
}

