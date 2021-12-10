package CasosDeUsoSem1;

import org.junit.jupiter.api.Test;
import edu.fiuba.algo3.modelo.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;


public class CasoDeUso2Test {
    @Test
    public void novatoVisitaBancoYVisitaBiblioteca() {
        Integer altitud = 1200;
        Integer latitud = 600;
        String pistaBanco = "La moneda es el Dolar Canadiense";
        String pistaBiblioteca = "El idioma oficial es el frances";
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
        Pista pista1 = new Pista(pistaBanco);
        Pista pista2 = new Pista(pistaBiblioteca);
        Banco banco = new Banco(pista1);
        Biblioteca biblioteca = new Biblioteca(pista2);

        Pista pistaObtenida1 = (Pista) banco.visitarEdificio(novato);
        Pista pistaObtenida2 = (Pista) biblioteca.visitarEdificio(novato);

        assertEquals(nombreCiudad, ciudad.darNombre());
        assertEquals(pistaBanco, pistaObtenida1.obtenerRespuesta());
        assertEquals(pistaBiblioteca, pistaObtenida2.obtenerRespuesta());
    }
}