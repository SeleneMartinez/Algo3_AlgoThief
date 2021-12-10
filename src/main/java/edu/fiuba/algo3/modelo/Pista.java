package edu.fiuba.algo3.modelo;

public  class Pista implements IRespuestaDelEvento {
    private String laPista;
    public Pista(String pista) {
        this.laPista = pista;
    }

    public String obtenerRespuesta() {
        return laPista;
    };
}
