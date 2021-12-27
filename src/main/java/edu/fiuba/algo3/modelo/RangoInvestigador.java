package edu.fiuba.algo3.modelo;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;

public class RangoInvestigador implements IRango{
    private int velocidad;
    public HashMap<String, List<Pista>> pistas;
    public RangoInvestigador(){
        this.velocidad = 1300;
        this.pistas = (new InicializadorDePistasDificiles()).inicializarPistas();
    }

    public HashMap<String, List<Pista>> obtenerPistaPorRango(){
        return this.pistas;
    }

    public boolean esNovato(){
        return false;
    }
    public boolean esDetective(){ return false; }
    public boolean esInvestigador(){ return true; }
    public boolean esSargento(){ return false; }

    public int tiempoDeViaje(Ciudad ciudadOrigen, Ciudad ciudadDestino) {
        return (int) Math.ceil(((double) ciudadOrigen.obtenerDistanciaA(ciudadDestino) / velocidad));
    }

    public RutaNormal obtenerRutaDeEscapeSegunRango(){
        return new RutaNormal();
    }

    public IRango obtenerRango(int casosResueltos)
    {
        IRango output = this;
        if(casosResueltos >= 20)
        {
            output = new RangoSargento();
        }
        return output;
    }
}
