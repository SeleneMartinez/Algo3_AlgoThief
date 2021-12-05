package edu.fiuba.algo3.modelo;

public class Biblioteca extends EdificioConPista {

    public Biblioteca(String ciudad) {
        this.pista = new PistaFacil("Biblioteca", ciudad);
    }

    public RespuestasDelEvento visitarEdificio(Policia policia) {
        policia.entrarEdificio();
        return pista;
    }
}
