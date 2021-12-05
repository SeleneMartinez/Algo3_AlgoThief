package edu.fiuba.algo3.modelo;

public class Maton {
    IArma arma;

    public Maton(IArma arma){this.arma = arma;}

    public IRespuestaDelEvento atacar(Policia policia) {
        return arma.herir(policia);
    }
}
