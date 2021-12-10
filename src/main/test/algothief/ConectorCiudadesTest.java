package algothief;
import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

public class ConectorCiudadesTest {

    @Test
    public void test01SeCreanConexionesDeCiudadesRandomEnLaCiudadQueLePaso() {
        List<Ciudad> ciudades = new ArrayList<Ciudad>();
        Ciudad unaCiudad = new Ciudad("Montevideo");
        ciudades = crearCiudades();
        ConectorCiudades conector = new ConectorCiudades(ciudades);
        conector.agregarConexiones(unaCiudad);

        assertEquals( unaCiudad.devolverCiudadesConectadas().size(), 2 );
        System.out.println( unaCiudad.devolverCiudadesConectadas().get( 0 ).darNombre() );
        System.out.println( unaCiudad.devolverCiudadesConectadas().get( 1 ).darNombre() );
    }

    @Test
    public void test02LasCiudadesQueConectoTienenConectadaASuCiudadDeOrigen() {
        List<Ciudad> ciudades = new ArrayList<Ciudad>();
        Ciudad ciudadOrigen = new Ciudad("Montevideo");
        ciudades = crearCiudades();
        ConectorCiudades conector = new ConectorCiudades(ciudades);
        conector.agregarConexiones(ciudadOrigen);
        Ciudad ciudadConexaUno = ciudadOrigen.devolverCiudadesConectadas().get(0);
        Ciudad ciudadConexaDos = ciudadOrigen.devolverCiudadesConectadas().get(1);

        assertEquals( ciudadConexaUno.devolverCiudadesConectadas().get(0).darNombre(), "Montevideo" );
        assertEquals( ciudadConexaDos.devolverCiudadesConectadas().get(0).darNombre(), "Montevideo" );
    }



    public List<Ciudad> crearCiudades() {
        List<Ciudad> ciudades = new ArrayList<Ciudad>();
        Ciudad buenosAires = new Ciudad("Argentina");
        Ciudad montreal = new Ciudad("Montreal");
        Ciudad berlin = new Ciudad("Berlin");
        Ciudad sidney = new Ciudad("Sidney");
        Ciudad moscu = new Ciudad("Moscu");
        ciudades.add(buenosAires);
        ciudades.add(montreal);
        ciudades.add(berlin);
        ciudades.add(sidney);
        ciudades.add(moscu);
        return ciudades;
    }
}
