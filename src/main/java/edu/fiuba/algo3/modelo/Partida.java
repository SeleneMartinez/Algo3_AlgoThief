package edu.fiuba.algo3.modelo;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;

public class Partida {
    Ladron ladron;
    Policia policia;
    List<Ciudad> ciudades;

    public Partida(){

    }
    public Partida(Policia policia, List<Ciudad> ciudades, Ladron ladron){
        this.ladron = ladron;
        this.policia = policia;
        this.ciudades = ciudades;
    }
    public Partida(String nombrePolicia, List<Ciudad> ciudades, Ladron ladron) {
        policia = new Policia(nombrePolicia);
        this.policia = policia;
        this.ladron = ladron;
        this.ciudades = ciudades;
        IRango rango = policia.obtenerRangoPolicia();
        HashMap<String, List<Pista>> pistasPorCiudad = rango.obtenerPistaPorRango();
    }

    private void setPistasEnCiudad(HashMap<String, List<Pista>> pistas){
        for (Ciudad ciudad : this.ciudades){
            List<Pista> pista = pistas.get(ciudad.nombre);
        }
    }

}
