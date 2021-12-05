package algothief;
import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class PistaFacilTest {

    @Test
    public void creoUnaPistaYDevuelveElMensajeCorrecto() {
        PistaFacil pista = new PistaFacil("Banco", "Mexico");
        String respuestaEsperada = "La moneda oficial son los Pesos Mexicanos";
        String respuesta = pista.obtenerRespuesta();
        assertEquals(respuestaEsperada, respuesta);
    }



}