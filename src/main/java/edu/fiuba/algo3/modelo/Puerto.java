package edu.fiuba.algo3.modelo;

public class Puerto extends EdificioConPista {
    public Puerto(String ciudad) {
        this.pista = new PistaFacil("Puerto", ciudad);
    }

    public RespuestasDelEvento visitarEdificio(Policia policia) {
        policia.entrarEdificio();
        return pista;
    }
}
