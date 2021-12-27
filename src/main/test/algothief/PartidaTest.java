package algothief;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


import java.util.List;

public class PartidaTest {
    @Test
    public void testConexiones(){
        Algothief algothief = new Algothief();
        algothief.iniciarJuego();
        algothief.nuevaPartida("Selene");
        Partida partida = algothief.getPartida();
        assertEquals(partida.getCiudadActual().darNombre(),"buenos aires");
        assertEquals(partida.obtenerCiduadAnterior().darNombre(),"buenos aires");

    }
}
