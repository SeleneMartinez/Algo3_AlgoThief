package edu.fiuba.algo3.modelo;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;

public class Algothief {
    private Partida partida;
    private List<Ciudad> ciudades;
    private List<Ladron> ladrones;

    public void iniciarJuego(){
        this.iniciarCiudades();
        this.iniciarLadrones();
        //this.partida = new Partida();
    }

    private void iniciarCiudades()  {
        InicializadorCiudades inicializadorCiudades = new InicializadorCiudades();
        ciudades = inicializadorCiudades.iniciarCiudades();
    }

    private void iniciarLadrones() {
        InicializadorLadrones inicializadorLadrones = new InicializadorLadrones();
        ladrones = inicializadorLadrones.iniciarLadrones();
    }
    
    public void nuevaPartida(String nombre) {
        partida = new Partida(nombre, ciudades, ladrones.get(0));
    }
    
    public Partida getPartida() {
        return partida;
    }
}
