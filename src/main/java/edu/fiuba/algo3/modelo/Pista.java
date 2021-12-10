package edu.fiuba.algo3.modelo;

public class Pista implements IRespuestaDelEvento {
    String pista;

    public Pista(String pistaNueva){
        this.pista = pistaNueva;
    }
    public String obtenerRespuesta(){
        return this.pista;
    };
}
