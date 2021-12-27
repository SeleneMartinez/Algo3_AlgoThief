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

public class PistaSexoControlador {
    public Algothief juego;

    public void iniciarPantallaPistaSexo(Algothief algothief) {
        juego = algothief;
    }

    public void sexoFemenino(ActionEvent event) {
        juego.getPartida().setBuscadorAsignarSexo("Femenino");
        this.volverPantallaInterpol(event);
    }

    public void sexoMasculino(ActionEvent event) {
        juego.getPartida().setBuscadorAsignarSexo("Masculino");
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
