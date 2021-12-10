package edu.fiuba.algo3.modelo;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;

public class RangoNovato implements IRango{
    private int velocidad;
    HashMap<String, List<Pista>> pistas;
    public RangoNovato() {
        this.velocidad = 900;
        this.pistas = (new InicializadorDePistasFaciles()).inicializarPistas();

    }

    public HashMap<String, List<Pista>> obtenerPistaPorRango(){
        return this.pistas;
    }
    public boolean esNovato() {
        return true;
    }
    public boolean esDetective(){ return false;}
    public boolean esInvestigador(){ return false;}
    public boolean esSargento(){ return false;}

    public int tiempoDeViaje(Ciudad ciudadOrigen, Ciudad ciudadDestino) {
        return (int) Math.ceil(((double) ciudadOrigen.obtenerDistanciaA(ciudadDestino) / velocidad));
    }

    public IRango obtenerRango(int casosResueltos)
    {
        IRango output = this;
        if(casosResueltos >= 5)
        {
            output = new RangoDetective();
        }
        return output;
    }
}

















