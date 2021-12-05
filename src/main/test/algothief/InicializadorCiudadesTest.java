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
        List<Ciudad> ciudades = new ArrayList<Ciudad>();
        JsonStreamParser parser = new JsonStreamParser(new FileReader("src/main/resources/ciudades.json"));
        JsonElement json = parser.next();
        JsonArray jsonArray = json.getAsJsonArray();
        for (int i = 0; i < jsonArray.size(); i++) {
            String nombreCiudad = (jsonArray.get(i).getAsJsonObject().get("Ciudad")).getAsString();
            String pais = (jsonArray.get(i).getAsJsonObject().get("Pais")).getAsString();
            int latitud = (jsonArray.get(i).getAsJsonObject().get("Latitud")).getAsInt();
            int altitud = (jsonArray.get(i).getAsJsonObject().get("Altitud")).getAsInt();

            Ubicacion ubicacion = new Ubicacion(altitud, latitud);
            Ciudad ciudad = new Ciudad(nombreCiudad, ubicacion);
            ciudades.add(ciudad);
        }
        assertEquals(30,ciudades.size());
    }
}
