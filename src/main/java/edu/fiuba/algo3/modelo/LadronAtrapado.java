package edu.fiuba.algo3.modelo;

public class LadronAtrapado implements IRespuestaDelEvento {
    String arresto = "Policia atrapó al ladron";

    public String obtenerRespuesta() {
        return arresto;
    }
}
