package algothief;
import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

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

    @Test
    public void testPoliciaNuevoEsNovato(){
        RangoNovato rangoTest = new RangoNovato();
        Policia policia = new Policia("Roberto");
        assertEquals(rangoTest, policia.obtenerRangoPolicia());
    }
}
