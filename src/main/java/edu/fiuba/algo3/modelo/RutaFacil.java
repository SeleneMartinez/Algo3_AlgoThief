package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class RutaFacil implements IRutaDeEscape{
    List<Ciudad> ciudadesDeLaRuta = new ArrayList<Ciudad>();
    List<Ciudad> ciudadesConectadas = new ArrayList<Ciudad>();
    Ciudad proximaCiudad;
    Ciudad ciudadActual;
    Random rand = new Random();

    public RutaFacil (Ciudad ciudad){
        this.ciudadActual = ciudad;
    }

    public RutaFacil (){

    }
    public void crearRuta(List<Ciudad> ciudades){
        List<Ciudad> ciudadesCopia = new ArrayList<>(ciudades);
        for (int i = 0; i < 3; i++) {
            int random = (new Random()).nextInt(ciudadesCopia.size());
            ciudadesConectadas.add(ciudadesCopia.remove(random));
            if(i>0){
                ciudadesConectadas.get(i-1).agregarConexion(ciudadesConectadas.get(i));
            }
        }
        for (int i = 2; i>0  ; i--) {
            ciudadesConectadas.get(i).agregarConexion(ciudadesConectadas.get(i-1));
        }

    }

    public void agregarCiudadesEnLaRuta() {

            int x = 1;
            ciudadesDeLaRuta.add(ciudadActual);
            while (x <= 3)
            {
            ciudadesConectadas.addAll(ciudadActual.devolverCiudadesConectadas());
            int int_random = rand.nextInt(ciudadesConectadas.size());
            ciudadesDeLaRuta.add(ciudadesConectadas.get(int_random));
            ciudadActual = ciudadesDeLaRuta.get(x);
            x++;


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
    // List<Ciudad> ciudadesDeLaRuta = new ArrayList<Ciudad>();
    // List<Ciudad> ciudadesConectadas = new ArrayList<Ciudad>();
    // Ciudad proximaCiudad;
    // Ciudad ciudadActual;
    // Random rand = new Random();

    // public RutaFacil (Ciudad ciudad){
    //     this.ciudadActual = ciudad;
    // }

    // public RutaFacil (){
    //     this.agregarCiudadesEnLaRuta();
    // }

    // public void agregarCiudadesEnLaRuta() {

    //         int x = 1;
    //         ciudadesDeLaRuta.add(ciudadActual);
    //         while (x <= 3)
    //         { ciudadesConectadas.clear();
    //         if (x==1){
    //             ciudadesConectadas.addAll(ciudadActual.devolverCiudadesConectadasPrimeraVez());
    //         }
    //         else {
    //             ciudadesConectadas.addAll(ciudadActual.devolverCiudadesConectadas());
    //         }
    //         int int_random = rand.nextInt(ciudadesConectadas.size());
    //         ciudadesDeLaRuta.add(ciudadesConectadas.get(int_random));
    //         ciudadActual = ciudadesDeLaRuta.get(x);
    //         x++;


    //     }
    // }
    // Iterator<Ciudad> iteradorCiudades= ciudadesDeLaRuta.iterator();
    // private void recorrerCiudades (){ proximaCiudad = iteradorCiudades.next();}
    // public Ciudad devolverProximaCiudad (){
    //     {
    //         this.recorrerCiudades ();
    //         return this.proximaCiudad;
    //     }
//     }
// }
