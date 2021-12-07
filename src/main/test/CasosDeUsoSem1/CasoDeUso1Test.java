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
        Integer altitud = 1200;
        Integer latitud = 600;
        String laPista = "La moneda es el Dolar Canadiense";
        String nombreCiudad = "Montreal";
        String nombrePolicia = "PoliNovato";
        //InicializadorCiudades initCiudades = new InicializadorCiudades();
        //InicializadorLadrones initLadrones = new InicializadorLadrones();
        //InicializadorDePistasFaciles initPistas = new InicializadorDePistasFaciles();


        Ladron ladron = new Ladron(
                "Merey Laroc",
                "Marron",
                "Femenino",
                "Escalada",
                "Joyas",
                "Limosina");
        Policia novato = new Policia(nombrePolicia);
        //HashMap<String, List<PistaFacil>> pistas = initPistas.inicializarPistas();
        //List<Ciudad> ciudades = initCiudades.iniciarCiudades();
        //List<Ladron> ladrones = initLadrones.iniciarLadrones();
        Ciudad ciudad = new Ciudad(nombreCiudad, new Ubicacion(altitud, latitud));
        PistaFacil pista = new PistaFacil(laPista);
        Banco banco = new Banco(pista);

        PistaFacil pistaObtenida = (PistaFacil) banco.visitarEdificio(novato);


        assertEquals(nombreCiudad, ciudad.darNombre());
        assertEquals(laPista, pistaObtenida.obtenerRespuesta());

    }
}
