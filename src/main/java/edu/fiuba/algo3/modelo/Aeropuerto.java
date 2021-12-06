package edu.fiuba.algo3.modelo;

public class Aeropuerto extends EdificioConPista {
    public Aeropuerto(Pista pista) {
        this.pista = pista;
    }

    public IRespuestaDelEvento visitarEdificio(Policia policia) {
        return super.visitarEdificio(policia);
    }
}
