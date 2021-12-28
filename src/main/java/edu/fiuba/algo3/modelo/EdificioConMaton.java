package edu.fiuba.algo3.modelo;

import java.util.Random;
/**
 Depende de la implementacion de policia
 */

public class EdificioConMaton implements IEdificio {

    //Maton maton = new Maton( new Cuchillo());
    Maton maton;
    public EdificioConMaton() {
        Random random = new Random();
        int num = random.nextInt(1);
        if (num == 1) {
            maton = new Maton(new Cuchillo());
        } else {
            maton = new Maton(new Pistola());
        }

    }

    public Amenaza visitarEdificio(Policia policia) {
        maton.atacar(policia);
        return new Amenaza();
    };

}
