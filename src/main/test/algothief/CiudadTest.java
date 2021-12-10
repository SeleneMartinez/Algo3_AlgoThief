package algothief;
import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

public class CiudadTest {

    @Test
    public void test01SeCreanCiudadesConCeroConexiones() {
        List<Ciudad> ciudades = new ArrayList<Ciudad>();
        ciudades = crearCiudades();
        for (Ciudad ciudad : ciudades)
            assertEquals(ciudad.devolverCiudadesConectadas().size(), 0);
    }


    @Test
    public void test02ConexionesAgregadasCorrectamente() {
        List<Ciudad> ciudades = new ArrayList<Ciudad>();
        ciudades = crearCiudades();

        ciudades.get(0).agregarConexion( ciudades.get(1) );//a la primera ciudad le conectamos 2 ciudades
        ciudades.get(0).agregarConexion( ciudades.get(2) );
        ciudades.get(1).agregarConexion( ciudades.get(4) );//a la segunda ciudad le conectamos 1 ciudades

        assertEquals(ciudades.get(0).devolverCiudadesConectadas().get(0).darNombre(), "Montreal" );
        assertEquals(ciudades.get(0).devolverCiudadesConectadas().get(1).darNombre(), "Berlin" );
        assertEquals(ciudades.get(1).devolverCiudadesConectadas().get(0).darNombre(), "Moscu" );
    }

    public List<Ciudad> crearCiudades() {
        List<Ciudad> ciudades = new ArrayList<Ciudad>();
        Ubicacion ubicacionArgentina = new Ubicacion(50,50);
        Ubicacion ubicacionMontreal = new Ubicacion(200,250);
        Ubicacion ubicacionBerlin = new Ubicacion(250,250);
        Ubicacion ubicacionSidney = new Ubicacion(300,350);
        Ubicacion ubicacionMoscu = new Ubicacion(350,350);
        ConectorCiudades conector = new ConectorCiudades();
        Ciudad buenosAires = new Ciudad("Argentina", ubicacionArgentina, conector);
        Ciudad montreal = new Ciudad("Montreal", ubicacionMontreal, conector);
        Ciudad berlin = new Ciudad("Berlin", ubicacionBerlin, conector);
        Ciudad sidney = new Ciudad("Sidney",ubicacionSidney, conector);
        Ciudad moscu = new Ciudad("Moscu", ubicacionMoscu, conector);
        ciudades.add(buenosAires);
        ciudades.add(montreal);
        ciudades.add(berlin);
        ciudades.add(sidney);
        ciudades.add(moscu);
        return ciudades;
    }


}
