package edu.fiuba.algo3.modelo;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;

public class Algothief {
    private Partida partida;
    private List<Ciudad> ciudades;
    private List<Ladron> ladrones;
    private HashMap<String, List<Pista>> pistasFaciles;

    public Algothief() {
        this.iniciarCiudades();
        this.iniciarLadrones();
        this.iniciarPistasFaciles();
        this.partida = new Partida();
    }

    private void iniciarCiudades()  {
        InicializadorCiudades inicializadorCiudades = new InicializadorCiudades();
        ciudades = inicializadorCiudades.iniciarCiudades();
    }

    private void iniciarLadrones() {
        InicializadorLadrones inicializadorLadrones = new InicializadorLadrones();
        ladrones = inicializadorLadrones.iniciarLadrones();
    }

    private void iniciarPistasFaciles() {
        InicializadorDePistasFaciles inicializadorDePistasFaciles = new InicializadorDePistasFaciles();
        pistasFaciles = inicializadorDePistasFaciles.inicializarPistas();
    }
}
