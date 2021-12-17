package CasosDeUsoSem1;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasoDeUso3Test {
    @Test
    public void detectiveViajeDeMontrealAMexico() {
        Integer altitud1 = -74;
        Integer latitud1 = 45;
        Integer altitud2 = -99;
        Integer latitud2 = 19;
        Integer horaEsperada = 2;
        String nombreCiudad1 = "Montreal";
        String nombreCiudad2 = "Mexico";
        String nombrePolicia = "PoliNovato";

        Policia novato = new Policia(nombrePolicia);
        Ciudad montreal = new Ciudad(nombreCiudad1, new Ubicacion(altitud1, latitud1));
        Ciudad mexico = new Ciudad(nombreCiudad2, new Ubicacion(altitud2, latitud2));
        
        novato.viajarDesdeHasta(montreal, mexico);
       
        assertEquals(horaEsperada, novato.obtenerHora());
     }
     
}
