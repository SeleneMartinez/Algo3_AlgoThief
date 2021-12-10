package edu.fiuba.algo3.modelo;

/**
 Depende de la implementacion de policia
 */

public class EdificioConLadron implements IEdificio {
    Ladron unLadron;

    public void ladronEntraAlEdificio(Ladron ladron) {
        unLadron = ladron;
    }

    public IRespuestaDelEvento visitarEdificio(Policia policia) {
        return policia.detener(unLadron);
    };

}
