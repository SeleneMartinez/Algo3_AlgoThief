package edu.fiuba.algo3.modelo;

/**
 Depende de la implementacion de policia
 */


public class EdificioConLadron {
    Ladron unLadron;

    public void ladronEntraAlEdificio(Ladron ladron) {
        unLadron = ladron;
    }

    public RespuestasDelEvento visitarEdificio(Policia policia) {
        if (policia.detener(unLadron)) {
            return new LadronAtrapado();
        }
        return new LadronEscapo();
    };




}
