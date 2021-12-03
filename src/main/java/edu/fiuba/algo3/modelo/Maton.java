package edu.fiuba.algo3.modelo;

public class Maton {
    Arma arma;

    public Maton(Cuchillo cuchillo) {
        this.arma = cuchillo;
    }

    public Maton(Pistola pistola) {
        this.arma = pistola;
    }

    public int atacar(Policia policia) {
        return arma.ataque(policia);
    }
}
