package CasosDeUsoSem1;

import org.junit.jupiter.api.Test;
import edu.fiuba.algo3.modelo.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;


public class CasoDeUso1Test {


    @Test
    public void sospechosoFemeninoRobaEnMontrealYDetectiveNovatoEntraABanco() throws FileNotFoundException {
        Integer altitud = -74;
        Integer latitud = 45;
        String laPista = "La moneda es el Dolar Canadiense";
        String nombreCiudad = "Montreal";
        String nombrePolicia = "PoliNovato";

        Ladron ladron = new Ladron(
                "Merey Laroc",
                "Marron",
                "Femenino",
                "Escalada",
                "Joyas",
                "Limosina");

        Policia novato = new Policia(nombrePolicia);
        Ciudad ciudad = new Ciudad(nombreCiudad, new Ubicacion(altitud, latitud));
        Pista pista = new Pista(laPista);
        Banco banco = new Banco(pista);

        Pista pistaObtenida = (Pista) banco.visitarEdificio(novato);

        assertEquals(nombreCiudad, ciudad.darNombre());
        assertEquals(laPista, pistaObtenida.obtenerRespuesta());

    }
}
