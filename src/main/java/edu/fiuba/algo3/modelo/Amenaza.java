package edu.fiuba.algo3.modelo;

public class Amenaza implements RespuestasDelEvento{
    String amenaza = "Matón atacó al policia";

    public String obtenerRespuesta() {
        return amenaza;
    }
}
