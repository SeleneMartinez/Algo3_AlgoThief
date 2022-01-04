package algothief;
import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PoliciaTest {
    @Test
    public void testInicializarPoliciaConNombre() {
        Policia policia = new Policia("Roberto");
        assertEquals("Roberto", policia.obtenerNombre());
    }

    @Test
    public void testPoliciaRecienInicializadoNoTieneCasosResueltos() {
        Policia policia = new Policia("Roberto");
        assertEquals(0, policia.cantidadDeCasosResueltos());
    }
    /**
    @Test
    public void viajeDe1800kmDemoraAlPoliciaNovato2hs(){
        Policia policia = new Policia("Roberto");
        Ubicacion uOrigen = new Ubicacion(0,0);
        Ubicacion uDestino = new Ubicacion(0,1800);
        Ciudad origen = new Ciudad("Origen", uOrigen);
        Ciudad destino = new Ciudad("Destino", uDestino);
        policia.viajarDesdeHasta(origen, destino);

        int horaEsperada = 2;

        assertEquals(horaEsperada, policia.obtenerHora());
    }
     */
    @Test
    public void policiaNuevoEsNovato(){
        Policia policia = new Policia("Roberto");

        assertTrue(policia.obtenerRangoPolicia() instanceof RangoNovato);
    }

    @Test
    public void policiaCon5CasosResueltosEsDetective(){
        Policia policia = new Policia("Roberto");
        for (int i = 0; i <5 ; i++) {
            policia.nuevoCasoResuelto();
        }
        assertTrue(policia.obtenerRangoPolicia() instanceof RangoDetective);
    }


}
