package algothief;

import edu.fiuba.algo3.modelo.InicializadorDePistasDificiles;
import edu.fiuba.algo3.modelo.InicializadorDePistasMedias;
import edu.fiuba.algo3.modelo.Pista;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class InicializadorPistasDificilesTest {
    @Test
    public void inicializaPistasTest() {
        InicializadorDePistasDificiles inicializadorDePistasFaciles = new InicializadorDePistasDificiles();
        HashMap<String, List<Pista>> ciudadesConPistas = inicializadorDePistasFaciles.inicializarPistas();
        assertEquals(30, ciudadesConPistas.size());
    }
}
