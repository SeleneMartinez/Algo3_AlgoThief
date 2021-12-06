package algothief;

import edu.fiuba.algo3.modelo.InicializadorLadrones;
import edu.fiuba.algo3.modelo.Ladron;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
public class InicializadorLadronesTest {

    @Test
    public void seInicializanTodosLosLadrones() throws FileNotFoundException {
        InicializadorLadrones inicializadorLadrones = new InicializadorLadrones();
        List<Ladron> ladrones = inicializadorLadrones.iniciarLadrones();
        assertEquals(10,ladrones.size());
    }
}
