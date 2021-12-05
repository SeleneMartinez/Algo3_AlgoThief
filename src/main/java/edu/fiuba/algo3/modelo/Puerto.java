package edu.fiuba.algo3.modelo;

public class Puerto extends EdificioConPista {
    public Puerto(String ciudad) {
        this.pista = new PistaFacil("Puerto", ciudad);
    }

    public IRespuestaDelEvento visitarEdificio(Policia policia) {
        return super.visitarEdificio(policia);
    }
}
