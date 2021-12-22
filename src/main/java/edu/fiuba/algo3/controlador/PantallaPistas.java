package edu.fiuba.algo3.controlador;


import edu.fiuba.algo3.modelo.Algothief;
import edu.fiuba.algo3.modelo.Ciudad;
import edu.fiuba.algo3.modelo.Partida;
import edu.fiuba.algo3.modelo.Pista;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

import java.util.List;

public class PantallaPistas {
    @FXML
    public Text ciudad;

    @FXML
    public Text pista;

    @FXML
    public Text tiempo;

    public Algothief juego;

    public void iniciarPantallaPistas(Algothief algothief) {
        juego = algothief;
        this.modificarTiempo();
        ciudad.setText(juego.getPartida().getCiudadActual().darNombre());

    }

    private void modificarTiempo() {
        Integer h = juego.getPartida().getHora();
        String h2 = Integer.toString(h);
        tiempo.setText(juego.getPartida().getDia() + " " + h2 + " hs");

    }

    public void getPistaEconomica(ActionEvent event) {
        Partida partida = juego.getPartida();
        Ciudad ciudadActual = partida.getCiudadActual();
        pista.setText("La pista es:" + "\n" + ciudadActual.devolverEdificios().get(0).visitarEdificio(partida.getPolicia()).obtenerRespuesta());
        this.modificarTiempo();
    }

    public void getPistaViajera(ActionEvent event) {
        Partida partida = juego.getPartida();
        Ciudad ciudadActual = partida.getCiudadActual();
        pista.setText("La pista es:" + "\n" + ciudadActual.devolverEdificios().get(1).visitarEdificio(partida.getPolicia()).obtenerRespuesta());
        this.modificarTiempo();
    }

    public void getPistaCultural(ActionEvent event) {
        Partida partida = juego.getPartida();
        Ciudad ciudadActual = partida.getCiudadActual();
        pista.setText("La pista es:" + "\n" + ciudadActual.devolverEdificios().get(2).visitarEdificio(partida.getPolicia()).obtenerRespuesta());
        this.modificarTiempo();
    }



}

