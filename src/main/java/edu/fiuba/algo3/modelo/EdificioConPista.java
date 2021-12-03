package edu.fiuba.algo3.modelo;

public class EdificioConPista implements Edificio {
    Pista pista;

    public RespuestasDelEvento visitarEdificio(Policia policia) {
        policia.entrarEdificio();
        return pista;
    }
}
