package CasosDeUsoSem1;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasoDeUso4Test {
    @Test
    public void detectiveVisitaVariasVecesAeropuertoYPuerto() {
        String pistaAeropuerto = "Bandera roja y blanca con una hoja";
        String pistaPuerto = "El idioma oficial es el frances";
        String nombrePolicia = "PoliNovato";

        Policia novato = new Policia(nombrePolicia);
        Pista pista1 = new Pista(pistaAeropuerto);
        Pista pista2 = new Pista(pistaPuerto);
        Aeropuerto aeropuerto = new Aeropuerto(pista1);
        Puerto puerto = new Puerto(pista2);

        for (int i = 0; i < 3; i++) {
            assertEquals(pistaAeropuerto, aeropuerto.visitarEdificio(novato).obtenerRespuesta());
        }

        for (int j = 0; j < 55; j++) {
            assertEquals(pistaPuerto, puerto.visitarEdificio(novato).obtenerRespuesta());
        }

    }

}
