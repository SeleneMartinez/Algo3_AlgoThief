package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 Esta clase es para que el usuario introduzca los datos que tiene para
 ver que orden de captura puede generar
 */

public class BuscadorLadrones {
    private List<Ladron> sospechosos;
    public List<Ladron> misSospechosos;

    public BuscadorLadrones(List<Ladron> ladrones) {
        sospechosos = ladrones;
        misSospechosos = ladrones;
    }

    public List<Ladron> devolverSospechosos() {
        return misSospechosos;
    }

    public void reiniciarBusqueda() {
        misSospechosos = sospechosos;
    }

    public void buscarPorSexo(String sexo) {
        List<Ladron> nuevaLista = new ArrayList<>();
        for (int i = 0; i < misSospechosos.size(); i++) {
            Ladron ladron = misSospechosos.get(i);
            if(ladron.getSexo().equals(sexo)) {
                nuevaLista.add(ladron);
            }
        }
        misSospechosos = nuevaLista;
    }

    public void buscarPorHobby(String hobby) {
        List<Ladron> nuevaLista = new ArrayList<>();
        for (int i = 0; i < misSospechosos.size(); i++) {
            Ladron ladron = misSospechosos.get(i);
            if(ladron.getHobby().equals(hobby)) {
                nuevaLista.add(ladron);
            }
        }
        misSospechosos = nuevaLista;
    }

    public void buscarPorCaracteristica(String caracteristica) {
        List<Ladron> nuevaLista = new ArrayList<>();
        for (int i = 0; i < misSospechosos.size(); i++) {
            Ladron ladron = misSospechosos.get(i);
            if(ladron.getCaracteristica().equals(caracteristica)) {
                nuevaLista.add(ladron);
            }
        }
        misSospechosos = nuevaLista;
    }

    public void buscarPorPelo(String pelo) {
        List<Ladron> nuevaLista = new ArrayList<>();
        for (int i = 0; i < misSospechosos.size(); i++) {
            Ladron ladron = misSospechosos.get(i);
            if(ladron.getPelo().equals(pelo)) {
                nuevaLista.add(ladron);
            }
        }
        misSospechosos = nuevaLista;

    }

    public void buscarPorVehiculo(String vehiculo) {
        List<Ladron> nuevaLista = new ArrayList<>();
        for (int i = 0; i < misSospechosos.size(); i++) {
            Ladron ladron = misSospechosos.get(i);
            if(ladron.getVehiculo().equals(vehiculo)) {
                nuevaLista.add(ladron);
            }
        }

        misSospechosos = nuevaLista;
    }
}