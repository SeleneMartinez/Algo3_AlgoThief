package edu.fiuba.algo3.modelo;


public class Pistola implements IArma {
    int demoraPorAtaque = 4;

    public IRespuestaDelEvento herir(Policia policia) {
        policia.demorar(demoraPorAtaque);
        return new Amenaza();
    }
}
