package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

public class Cuchillo implements IArma {
    int demoraPorSegundoAtaque = 1;
    private int demoraPorAtaque = 2;

    public IRespuestaDelEvento herir(Policia policia){
        policia.demorar(demoraPorAtaque);
        demoraPorAtaque = demoraPorSegundoAtaque;
        return new Amenaza();
    }
}
