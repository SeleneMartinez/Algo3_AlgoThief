package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.Vista.PantallaFinal;
import edu.fiuba.algo3.modelo.Algothief;
import edu.fiuba.algo3.modelo.Ciudad;
import edu.fiuba.algo3.modelo.Partida;
import edu.fiuba.algo3.modelo.Pista;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
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
        Partida partida = juego.getPartida();
        Integer h = partida.getHora();
        String h2 = Integer.toString(h);
        tiempo.setText(partida.getDia() + " " + h2 + " hs");
        ciudad.setText(juego.getPartida().getCiudadActual().darNombre());

    }

    private void modificarTiempo(ActionEvent event) {
        Partida partida = juego.getPartida();
        if (partida.partidaTerminada()) {
            this.pantallaFinal(event);
        }
        Integer h = partida.getHora();
        String h2 = Integer.toString(h);
        tiempo.setText(partida.getDia() + " " + h2 + " hs");

    }
    
    private void pantallaFinal(ActionEvent event) {
        try {
            Object eventSource = event.getSource();
            Node sourceAsNode = (Node) eventSource;
            Scene sceneActual = sourceAsNode.getScene();
            Window window = sceneActual.getWindow();
            Stage stage = (Stage) window;
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/pantallaFinal.fxml"));
            Parent root = loader.load();
            PantallaFinal pantalla = loader.getController();
            pantalla.iniciarPantallaFinal(juego);
            sceneActual.setRoot(root);
            stage.setScene(sceneActual);
            stage.setMaximized(true);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void volverPantallaPrincipal(ActionEvent event) {
        try {
            Object eventSource = event.getSource();
            Node sourceAsNode = (Node) eventSource;
            Scene sceneActual = sourceAsNode.getScene();
            Window window = sceneActual.getWindow();
            Stage stage = (Stage) window;
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/pantallaPrincipal.fxml"));
            Parent root = loader.load();
            PantallaPrincipalControlador pantalla = loader.getController();
            pantalla.iniciarPantallaPrincipal(juego);
            sceneActual.setRoot(root);
            stage.setScene(sceneActual);
            stage.setMaximized(true);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    

    public void getPistaEconomica(ActionEvent event) {
        Partida partida = juego.getPartida();
        Ciudad ciudadActual = partida.getCiudadActual();
        pista.setText("La pista es:" + "\n" + ciudadActual.devolverEdificios().get(0).visitarEdificio(partida.getPolicia()).obtenerRespuesta());
        this.modificarTiempo(event);
    }

    public void getPistaViajera(ActionEvent event) {
        Partida partida = juego.getPartida();
        Ciudad ciudadActual = partida.getCiudadActual();
        pista.setText("La pista es:" + "\n" + ciudadActual.devolverEdificios().get(1).visitarEdificio(partida.getPolicia()).obtenerRespuesta());
        this.modificarTiempo(event);
    }

    public void getPistaCultural(ActionEvent event) {
        Partida partida = juego.getPartida();
        Ciudad ciudadActual = partida.getCiudadActual();
        pista.setText("La pista es:" + "\n" + ciudadActual.devolverEdificios().get(2).visitarEdificio(partida.getPolicia()).obtenerRespuesta());
        this.modificarTiempo(event);
    }



}

