package edu.fiuba.algo3.modelo;

import java.util.HashMap;
import java.util.List;

public class RangoSargento implements IRango{
    private int velocidad;
    private HashMap<String, List<Pista>> pistas;

    public RangoSargento(){
        this.velocidad = 1500;
        this.pistas = (new InicializadorDePistasDificiles()).inicializarPistas();
    }

    public HashMap<String, List<Pista>> obtenerPistaPorRango(){
        return this.pistas;
    }
    public boolean esNovato() {
        return false;
    }
    public boolean esDetective(){ return false; }
    public boolean esInvestigador(){ return false; }
    public boolean esSargento(){ return true; }

    public int tiempoDeViaje(Ciudad ciudadOrigen, Ciudad ciudadDestino) {
        return (ciudadOrigen.obtenerDistanciaA(ciudadDestino) / velocidad);
    }

    public IRango obtenerRango(int casosResueltos)
    {
        return this;
    }
}