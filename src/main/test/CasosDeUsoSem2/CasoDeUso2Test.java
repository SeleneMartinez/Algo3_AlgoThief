package CasosDeUsoSem2;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CasoDeUso2Test {

    @Test
    public void policiaConRangoInvestigadorTomaUnCasoDeRoboYViajaAMexico(){
        Policia policiaInvestigador = new Policia("Rock");
        for (int i = 0; i < 11; i++){
            policiaInvestigador.nuevoCasoResuelto();
        }

        IRango rango = policiaInvestigador.obtenerRangoPolicia();
        Ciudad ciudadMontreal = new Ciudad("Montreal", new Ubicacion(45, -74));
        Ciudad ciudadMexico = new Ciudad("Mexico", new Ubicacion(19, -99));

        policiaInvestigador.viajarDesdeHasta(ciudadMontreal, ciudadMexico);
        assertTrue(policiaInvestigador.cantidadDeCasosResueltos() > 10);
        assertTrue(policiaInvestigador.obtenerRangoPolicia() instanceof RangoInvestigador);
        assertEquals(1, rango.tiempoDeViaje(ciudadMontreal, ciudadMexico));

    }
}
