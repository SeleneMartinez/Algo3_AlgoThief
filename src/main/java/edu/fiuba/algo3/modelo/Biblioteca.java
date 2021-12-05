package edu.fiuba.algo3.modelo;

public class Biblioteca extends EdificioConPista {

    public Biblioteca(String ciudad) {
        this.pista = new PistaFacil("Biblioteca", ciudad);
    }

    public IRespuestaDelEvento visitarEdificio(Policia policia) {
        return super.visitarEdificio(policia);
    }
}
