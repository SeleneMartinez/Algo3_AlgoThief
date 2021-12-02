package edu.fiuba.algo3.modelo;

/**
 Depende de la implementacion de policia
 */

public class EdificioConMaton implements Edificio {
    Maton maton = new Maton();

    public Amenaza visitarEdificio(Policia policia) {
        policia.herir(maton.atacar());
        return new Amenaza();
    };

}
