package edu.fiuba.algo3.modelo;

public class Biblioteca extends EdificioConPista {

    public Biblioteca(Pista pista) {
        this.pista = pista;
    }

    public IRespuestaDelEvento visitarEdificio(Policia policia) {
        return super.visitarEdificio(policia);
    }
}
