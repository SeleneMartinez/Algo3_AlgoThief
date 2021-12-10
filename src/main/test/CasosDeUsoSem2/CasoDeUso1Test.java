package CasosDeUsoSem2;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasoDeUso1Test {

    @Test
    public void detectiveSufreHeridaDeCuchilloYdetectiveDuerme() {
        String respuestaEsperada = "Matón atacó al policia";
        Integer horaEsperada = 10;
        String nombrePolicia = "PoliNovato";
        Policia novato = new Policia(nombrePolicia);
        Cuchillo cuchillo = new Cuchillo();
        Maton maton = new Maton(cuchillo);

        Amenaza respuesta = (Amenaza) maton.atacar(novato);
        novato.dormir();

        assertEquals(respuestaEsperada, respuesta.obtenerRespuesta());
        assertEquals(horaEsperada, novato.obtenerHora());
    }
}