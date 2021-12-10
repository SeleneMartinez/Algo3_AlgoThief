package algothief;

import edu.fiuba.algo3.modelo.InicializadorDePistasFaciles;
import edu.fiuba.algo3.modelo.InicializadorLadrones;
import edu.fiuba.algo3.modelo.Ladron;
import edu.fiuba.algo3.modelo.Pista;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
public class InicializadorDePistasFacilesTest {

    @Test
    public void seInicializanLasPistas() throws FileNotFoundException {
        InicializadorDePistasFaciles inicializadorDePistasFaciles = new InicializadorDePistasFaciles();
        HashMap<String, List<Pista>> ciudadesConPistas = inicializadorDePistasFaciles.inicializarPistas();
        assertEquals(30, ciudadesConPistas.size());
    }
}