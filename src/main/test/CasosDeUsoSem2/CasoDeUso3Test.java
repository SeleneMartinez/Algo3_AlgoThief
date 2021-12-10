package CasosDeUsoSem2;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CasoDeUso3Test {

    @Test
    public void cargarDatosEnComputadoraYBuscarSospechosos(){
        List<Ladron> ladrones = new ArrayList<Ladron>();
        Ladron ladron1 = new Ladron("Len Bulk","Rojo", "Masculino","Escalada","Tatuaje","Convertible");
        Ladron ladron2 = new Ladron("Ihor Ihorovitch", "Rubio","Masculino", "Croquet", "Tatuaje", "Limosina");
        Ladron ladron3 = new Ladron("Scar Graynolt", "Rojo", "Masculino", "Croquet", "Anillo", "Limosina");
        ladrones.add(ladron1);
        ladrones.add(ladron2);
        ladrones.add(ladron3);
        BuscadorLadrones buscador = new BuscadorLadrones(ladrones);

        buscador.buscarPorVehiculo("Limosina");
        List<Ladron> sospechososConLimosina = buscador.devolverSospechosos();
        buscador.reiniciarBusqueda();
        buscador.buscarPorCaracteristica("Tatuaje");
        List<Ladron> sospechososConTatuaje = buscador.devolverSospechosos();
        buscador.reiniciarBusqueda();
        buscador.buscarPorCaracteristica("Tatuaje");
        buscador.buscarPorVehiculo("Limosina");
        List<Ladron> sospechoso = buscador.devolverSospechosos();

        assertTrue(sospechososConLimosina.contains(ladron2));
        assertTrue(sospechososConLimosina.contains(ladron3));
        assertFalse(sospechososConLimosina.contains(ladron1));
        assertTrue(sospechososConTatuaje.contains(ladron1));
        assertTrue(sospechososConTatuaje.contains(ladron2));
        assertTrue(sospechoso.contains(ladron2));
    }
}
