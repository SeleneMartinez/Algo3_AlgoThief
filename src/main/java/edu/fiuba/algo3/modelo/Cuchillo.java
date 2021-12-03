package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

public class Cuchillo implements Arma {
    int damagePrincipal = 2;
    int damageSecundario = 1;
    List<Policia> policiasAtacados = new ArrayList<Policia>();

    public int ataque(Policia policia) {
        if (!policiasAtacados.contains(policia)) {
            policiasAtacados.add(policia);
            return damagePrincipal;
        }
        return damageSecundario;
    }
}
