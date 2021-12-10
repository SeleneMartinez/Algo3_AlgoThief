package edu.fiuba.algo3.modelo;

public class OrdenDeCaptura implements IOrdenDeCaptura{
    Ladron ladron;
    public OrdenDeCaptura(Ladron ladron){
        this.ladron = ladron;
    }
    public IRespuestaDelEvento capturar(Ladron ladronEnEdificio){
        IRespuestaDelEvento output = ladron.escapar();
        if(this.ladron == ladronEnEdificio){
            output = ladronEnEdificio.entregarse();
        }
        return output;
    }
}