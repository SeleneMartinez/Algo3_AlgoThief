package CasosDeUsoSem1;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasoDeUso5Test {
    @Test
    public void detectiveRecibeHeridaDeCuchilloYDuerme() {
        String respuestaEsperada = "Matón atacó al policia";
        Integer horaEsperada = 17;
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
