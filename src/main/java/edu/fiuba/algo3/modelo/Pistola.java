package edu.fiuba.algo3.modelo;


public class Pistola implements Arma {
    public int damage = 4;

    public int ataque(Policia policia) {
        return damage;
    }
}
