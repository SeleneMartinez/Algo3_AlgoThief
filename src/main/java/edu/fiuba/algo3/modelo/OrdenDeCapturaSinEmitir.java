package edu.fiuba.algo3.modelo;

public class OrdenDeCapturaSinEmitir implements IOrdenDeCaptura{
    public IRespuestaDelEvento capturar(Ladron ladron){
        return new LadronEscapo();
    }
}