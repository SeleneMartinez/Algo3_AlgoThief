package edu.fiuba.algo3.modelo;

public class Ladron{

    String descripcion;

    public Ladron(String descripcion){this.descripcion = descripcion;}

    public IRespuestaDelEvento entregarse(){
        return new LadronAtrapado();
    }

    public IRespuestaDelEvento escapar()
    {
        return new LadronEscapo();
    }
}