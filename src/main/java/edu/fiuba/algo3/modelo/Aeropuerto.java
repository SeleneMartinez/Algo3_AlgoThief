package edu.fiuba.algo3.modelo;

public class Aeropuerto extends EdificioConPista {
    public Aeropuerto(String ciudad) {
        this.pista = new PistaFacil("Aeropuerto", ciudad);
    }

    public IRespuestaDelEvento visitarEdificio(Policia policia) {
        return super.visitarEdificio(policia);
    }
}
