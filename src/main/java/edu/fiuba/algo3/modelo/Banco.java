package edu.fiuba.algo3.modelo;

public class Banco extends EdificioConPista {

    public Banco(String ciudad) {
        this.pista = new PistaFacil("Banco", ciudad);
    }

    public RespuestasDelEvento visitarEdificio(Policia policia) {
        policia.entrarEdificio();
        return pista;
    }
}
