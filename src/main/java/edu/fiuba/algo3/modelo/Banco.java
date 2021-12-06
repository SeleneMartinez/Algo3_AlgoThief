package edu.fiuba.algo3.modelo;

public class Banco extends EdificioConPista {

    public Banco(Pista pista) {
        this.pista = pista;
    }

    public IRespuestaDelEvento visitarEdificio(Policia policia) {
        return super.visitarEdificio(policia);
    }
}
