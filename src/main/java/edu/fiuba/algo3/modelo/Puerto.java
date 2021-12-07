package edu.fiuba.algo3.modelo;

public class Puerto extends EdificioConPista {
    public Puerto(Pista pista) {
        this.pista = pista;
    }

    public IRespuestaDelEvento visitarEdificio(Policia policia) {
        return super.visitarEdificio(policia);
    }
}
