package edu.fiuba.algo3.modelo;

/**
 Depende de la implementacion de policia
 */

public class EdificioConMaton implements IEdificio {
    Maton maton = new Maton( new Cuchillo());

    public Amenaza visitarEdificio(Policia policia) {
        maton.atacar(policia);
        return new Amenaza();
    };

}
