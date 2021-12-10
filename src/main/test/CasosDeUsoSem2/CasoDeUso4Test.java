package CasosDeUsoSem2;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CasoDeUso4Test {

    @Test
    public void intentarAtraparLadronSinOrden(){
        Ladron ladron = new Ladron("Len Bulk","Rojo","Masculino","Escalada","Tatuaje","Convertible");
        Policia policia = new Policia("Rock");
        IRespuestaDelEvento rtaAlIntentarDetenerSinOrden = policia.detener(ladron);

        assertEquals("Ladrón escapó", rtaAlIntentarDetenerSinOrden.obtenerRespuesta());
        assertTrue(policia.obtenerRangoPolicia() instanceof RangoNovato);

    }
}
