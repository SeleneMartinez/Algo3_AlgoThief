package edu.fiuba.algo3.modelo;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Partida {
    Ladron ladron;
    Policia policia;
    List<Ciudad> ciudades;
    HashMap<String, List<Pista>> pistasPorCiudad;
    Ciudad ciudadActual;
    BuscadorLadrones buscador;
    /**
    public Partida(){

    }
    public Partida(Policia policia, List<Ciudad> ciudades, Ladron ladron){
        this.ladron = ladron;
        this.policia = policia;
        this.ciudades = ciudades;
    }
    */
    public Partida(String nombrePolicia, List<Ciudad> ciudades, Ladron ladron) {
        policia = new Policia(nombrePolicia);
        //this.policia = policia;
        this.ladron = ladron;
        this.ciudades = ciudades;
        IRango rango = policia.obtenerRangoPolicia();
        //HashMap<String, List<Pista>> pistasPorCiudad = rango.obtenerPistaPorRango();
        pistasPorCiudad = rango.obtenerPistaPorRango();
        this.setPistasEnCiudad(pistasPorCiudad);
    }

    private void setPistasEnCiudad(HashMap<String, List<Pista>> pistas){
        Random random = new Random();
        ciudadActual = ciudades.get(random.nextInt(ciudades.size()));
        //ConectorCiudades conexiones = new ConstructorCiudades(ciudades);
        for (Ciudad ciudad : this.ciudades) {
            //conexiones.agregarConexiones(ciudad)
            List<Pista> pista = pistas.get(ciudad.darNombre());
            for (int i = 0; i < 3; i++) {
                if (i == 0) {
                    ciudad.agregarEdificio(new Banco(pista.get(i)));
                } else if (i == 1) {
                    ciudad.agregarEdificio(new Aeropuerto(pista.get(i)));
                } else {
                    ciudad.agregarEdificio(new Biblioteca(pista.get(i)));
                }
            }
        }
        //RutaFacil ruta = new RutaFacil(ciudadActual);
        //ladron.agregarRutaEscape(ruta);
        
    }
    
    public void asignarBuscador(List<Ladron> ladrones) {
        buscador = new BuscadorLadrones(ladrones);
    }
    
    public void buscadorAsignarPelo(String color) {
        buscador.buscarPorPelo(color);
    }


    
    public String getDia() {
        return policia.obtenerDia();
    }

    public int getHora() {
        return policia.obtenerHora();
    }

    public Ciudad getCiudadActual() {
        return ciudadActual;
    }

    public Policia getPolicia() {
        return policia;
    }
    
    public boolean partidaTerminada() {
        return policia.finTiempo();
    }

}
