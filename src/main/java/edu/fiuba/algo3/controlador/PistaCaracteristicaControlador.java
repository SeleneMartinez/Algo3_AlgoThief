package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Algothief;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class PistaCaracteristicaControlador {
    public Algothief juego;

    public void iniciarPantallaPistaCaracteristica(Algothief algothief) {
        juego = algothief;
    }

    public void caracteristicaAnillo(ActionEvent event) {
        juego.getPartida().buscadorAsignarCaracteristica("Anillo");
        this.volverPantallaInterpol(event);
    }

    public void caracteristicaJoyas(ActionEvent event) {
        juego.getPartida().buscadorAsignarCaracteristica("Joyas");
        this.volverPantallaInterpol(event);
    }

    public void caracteristicaTatuaje(ActionEvent event) {
        juego.getPartida().buscadorAsignarCaracteristica("Tatuaje");
        this.volverPantallaInterpol(event);
    }

    public void volverPantallaInterpol(ActionEvent event) {
        try {
            Object eventSource = event.getSource();
            Node sourceAsNode = (Node) eventSource;
            Scene sceneActual = sourceAsNode.getScene();
            Window window = sceneActual.getWindow();
            Stage stage = (Stage) window;
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/pantallaInterpol.fxml"));
            Parent root = loader.load();
            PantallaInterpolControlador pantalla = loader.getController();
            pantalla.iniciarPantallaInterpol(juego);
            sceneActual.setRoot(root);
            stage.setScene(sceneActual);
            stage.setMaximized(true);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
