package edu.fiuba.algo3.modelo;

public class Banco extends EdificioConPista {

    public Banco(String ciudad) {
        this.pista = new PistaFacil("Banco", ciudad);
    }

    public IRespuestaDelEvento visitarEdificio(Policia policia) {
        return super.visitarEdificio(policia);
    }
}
