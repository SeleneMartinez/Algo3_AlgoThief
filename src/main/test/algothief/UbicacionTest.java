package algothief;
import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class UbicacionTest {

    @Test
    public void obtieneDistanciaCorrecta(){
        Ubicacion origen = new Ubicacion(200, 100);
        Ubicacion destino = new Ubicacion(100, 50);

        int distancia = origen.calcularDistancia(destino);

        assertEquals(111,distancia);
    }
}
