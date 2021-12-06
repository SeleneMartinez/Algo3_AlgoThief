package algothief;

import edu.fiuba.algo3.modelo.Ciudad;
import edu.fiuba.algo3.modelo.InicializadorCiudades;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.FileNotFoundException;

import java.util.List;

public class InicializadorCiudadesTest {
    InicializadorCiudades inicializadorCiudades= new InicializadorCiudades();

    @Test
    public void seInicianTodasLasCiudadesTest() throws FileNotFoundException {
        List<Ciudad> ciudades = inicializadorCiudades.iniciarCiudades();
        assertEquals(30,ciudades.size());
    }
}
