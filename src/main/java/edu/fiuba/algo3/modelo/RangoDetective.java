package edu.fiuba.algo3.modelo;

import java.util.HashMap;
import java.util.List;

public class RangoDetective implements IRango{

    private int velocidad;
    private HashMap<String, List<Pista>> pistas;

    public RangoDetective(){
        this.velocidad = 1100;
        this.pistas = (new InicializadorDePistasMedias()).inicializarPistas();
    }

    public HashMap<String, List<Pista>> obtenerPistaPorRango(){
        return this.pistas;
    }

    public boolean esNovato() {
        return false;
    }
    public boolean esDetective(){return true;}
    public boolean esInvestigador(){ return false;}
    public boolean esSargento(){ return false;}

    public RutaNormal obtenerRutaDeEscapeSegunRango(){
        return new RutaNormal();
    }

    public int tiempoDeViaje(Ciudad ciudadOrigen, Ciudad ciudadDestino) {
        return (int) Math.ceil(((double) ciudadOrigen.obtenerDistanciaA(ciudadDestino) / velocidad));
    }

    public IRango obtenerRango(int casosResueltos)
    {
        IRango output = this;
        if(casosResueltos >= 10)
        {
            output = new RangoInvestigador();
        }
        return output;
    }
}