package edu.fiuba.algo3.modelo;

public class EdificioConPista implements IEdificio {
    Pista pista;
    IVisita visita = new PrimeraVisita();

    public IRespuestaDelEvento visitarEdificio(Policia policia) {
        visita = visita.recibirVisita(policia);
        return pista;
    }
}
