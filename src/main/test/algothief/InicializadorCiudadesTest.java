package algothief;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonStreamParser;
import edu.fiuba.algo3.modelo.Ciudad;
import edu.fiuba.algo3.modelo.InicializadorCiudades;
import edu.fiuba.algo3.modelo.Ubicacion;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class InicializadorCiudadesTest {
    InicializadorCiudades inicializadorCiudades= new InicializadorCiudades();

    @Test
    public void seInicianTodasLasCiudadesTest() throws FileNotFoundException {
        List<Ciudad> ciudades = inicializadorCiudades.iniciarCiudades();
        assertEquals(30,ciudades.size());
    }
}
