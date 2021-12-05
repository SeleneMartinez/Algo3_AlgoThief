package edu.fiuba.algo3.modelo;

public class OrdenDeCapturaSinEmitir{

    public IRespuestaDelEvento capturar(Ladron ladron){
        return new LadronEscapo();
    }
}