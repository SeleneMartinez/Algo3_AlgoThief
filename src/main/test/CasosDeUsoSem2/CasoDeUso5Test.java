package CasosDeUsoSem2;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CasoDeUso5Test {

    @Test
    public void policiaTomaUnCasoEmiteLaOrdenYAtrapaAlLadron(){
        Ladron ladronSospechoso = new Ladron("Nick Brunch", "Negro","Maculino", "Escalada","Negro","Moto");
        Policia detective = new Policia("Rock");
        OrdenDeCaptura orden = new OrdenDeCaptura(ladronSospechoso);
        Ciudad ciudadOrigen = new Ciudad("Buenos Aires", new Ubicacion(800, 350));
        Ciudad ciudadFinal = new Ciudad("Lima", new Ubicacion(650, 600));
        Pista pistaBanco = new PistaFacil("Su moneda es el sol");
        Banco banco = new Banco(pistaBanco);
        EdificioConLadron edificioConLadron = new EdificioConLadron();

        for (int i = 0; i < 6; i++){
            Ladron ladronTest = new Ladron("Len Bulk", "Maculino", "Escalada", "Rojo", "Tatuaje", "Convertible");
            OrdenDeCaptura ordenLadronTest = new OrdenDeCaptura(ladronTest); //capturo al mismo a modo de ejemplo para llegar a 6 arrestos
            detective.recibirOrdenDeCaptura(ordenLadronTest);
            detective.detener(ladronTest);
            detective.nuevoCasoResuelto();
        }

        IRango rangoDetective = detective.obtenerRangoPolicia();
        ciudadOrigen.agregarEdificio(banco);
        ciudadFinal.agregarEdificio(edificioConLadron);
        edificioConLadron.ladronEntraAlEdificio(ladronSospechoso);

        ciudadOrigen.devolverEdificios();
        banco.visitarEdificio(detective);
        detective.viajarDesdeHasta(ciudadOrigen, ciudadFinal);
        detective.recibirOrdenDeCaptura(orden);
        IRespuestaDelEvento eventoDetenerLadron = edificioConLadron.visitarEdificio(detective); //como el Edificio contiene al ladron, lo atrapa
        detective.nuevoCasoResuelto();

        assertTrue(detective.obtenerRangoPolicia() instanceof RangoDetective);
        assertEquals("Rock", detective.obtenerNombre());
        assertNotNull(banco.visitarEdificio(detective));
        assertTrue(banco.visitarEdificio(detective) instanceof PistaFacil);
        assertEquals(7, detective.cantidadDeCasosResueltos());
        assertEquals(1, rangoDetective.tiempoDeViaje(ciudadOrigen, ciudadFinal));
        assertEquals("Policia atrapó al ladron", eventoDetenerLadron.obtenerRespuesta());
    }
}
