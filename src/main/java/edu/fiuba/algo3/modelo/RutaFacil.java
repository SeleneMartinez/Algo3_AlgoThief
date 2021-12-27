package edu.fiuba.algo3.modelo;

import java.util.*;

public class RutaFacil implements IRutaDeEscape{
    List<Ciudad> ciudadesDeLaRuta = new ArrayList<Ciudad>();
    List<Ciudad> ciudadesConectadas = new ArrayList<Ciudad>();
    Ciudad proximaCiudad;
    Ciudad ciudadActual;
    Random rand = new Random();
    Integer indice = 0;

    public RutaFacil (Ciudad ciudad){
        this.ciudadActual = ciudad;
    }

    public RutaFacil (){

    }

    public void agregarMatones(Ciudad ciudad) {
        Random random = new Random();
        int indice = random.nextInt(3);
        ciudad.eliminarEdificios();
        for (int i = 0; i < 3; i++) {
            if (i == indice) {
                ciudad.agregarEdificio(new EdificioConLadron());
            } else {
                ciudad.agregarEdificio(new EdificioConMaton());
            }
        }
    }

    public void agregarPistas(List<Pista> pistaLadron, HashMap<String, List<Pista>> pistasPorCiudad){
        List<Pista> pistasCopia = new ArrayList<Pista>(pistaLadron);
        int random = 1;
        for (int i = 0; i < ciudadesConectadas.size(); i++) {
            if (i == ciudadesConectadas.size() - 1) {
                this.agregarMatones(ciudadesConectadas.get(i));
            } else {
                Ciudad proxCiudad = ciudadesConectadas.get(i + 1);
                List<Pista> pistas = pistasPorCiudad.get(proxCiudad.darNombre());
                ciudadesConectadas.get(i).eliminarEdificios();
                ciudadesConectadas.get(i).agregarEdificio(new Banco(pistas.get(0)));
                ciudadesConectadas.get(i).agregarEdificio(new Aeropuerto(pistas.get(1)));
                ciudadesConectadas.get(i).agregarEdificio(new Biblioteca(pistas.get(2)));
                if(random <5){
                    int randomPista = (new Random()).nextInt(pistasCopia.size());
                    ciudadesConectadas.get(i).agregarPista(pistasCopia.remove(randomPista));
                    random += 1;
                }
            }
        }

        /**
        for (Ciudad ciudad : ciudadesConectadas) {
            //int random = 1;
            if(random <5){
                int randomPista = (new Random()).nextInt(pistasCopia.size());
                ciudad.agregarPista(pistasCopia.remove(randomPista));
                random += 1;
            }

        }
         */
    }
    public void crearRuta(List<Ciudad> ciudades){
        /**
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
         */
        List<Integer> indices = new ArrayList<Integer>();
        for (int i = 0; i < 4; i++) {
            int random = (new Random()).nextInt(ciudades.size());
            while (indices.contains(random)) {
                random = (new Random()).nextInt(ciudades.size());
            }
            indices.add(random);
            //ciudadesConectadas.add(ciudades.remove(random));
            ciudadesConectadas.add(ciudades.get(random));
            if(i>0){
                ciudadesConectadas.get(i-1).agregarConexion(ciudadesConectadas.get(i));
            }
        }
        /**
        for (int i = 2; i>0  ; i--) {
            ciudadesConectadas.get(i).agregarConexion(ciudadesConectadas.get(i-1));
        }
         */


        ciudadActual = ciudadesConectadas.get(0);
        proximaCiudad = ciudadesConectadas.get(1);

    }


    public boolean ciudadEnLaRuta(Ciudad ciudad) {
        for (Ciudad ciudadEnRuta: ciudadesConectadas) {
            if (ciudadEnRuta.darNombre().equals(ciudad.darNombre())) {
                return true;
            }
        }
        return false;
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

    public Ciudad devolverCiudadActual() {
        return ciudadActual;
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
