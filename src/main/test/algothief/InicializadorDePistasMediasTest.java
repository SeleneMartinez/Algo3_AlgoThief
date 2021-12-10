package algothief;

import edu.fiuba.algo3.modelo.InicializadorDePistasFaciles;
import edu.fiuba.algo3.modelo.InicializadorDePistasMedias;
import edu.fiuba.algo3.modelo.Pista;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InicializadorDePistasMediasTest {
    @Test
    public void seInicializanLasPistas() {
        InicializadorDePistasMedias inicializadorDePistasFaciles = new InicializadorDePistasMedias();
        HashMap<String, List<Pista>> ciudadesConPistas = inicializadorDePistasFaciles.inicializarPistas();
        assertEquals(30, ciudadesConPistas.size());
    }
}
