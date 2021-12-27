package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Algothief;
import edu.fiuba.algo3.modelo.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class PistaPeloControlador {
    public Algothief juego;

    public void iniciarPantallaPistaPelo(Algothief algothief) {
        juego = algothief;
    }

    public void peloMarron(ActionEvent event) {
        juego.getPartida().buscadorAsignarPelo("Marron");
        this.volverPantallaInterpol(event);
    }

    public void peloRubio(ActionEvent event) {
        juego.getPartida().buscadorAsignarPelo("Rubio");
        this.volverPantallaInterpol(event);
    }

    public void peloNegro(ActionEvent event) {
        juego.getPartida().buscadorAsignarPelo("Negro");
        this.volverPantallaInterpol(event);
    }

    public void peloRojo(ActionEvent event) {
        juego.getPartida().buscadorAsignarPelo("Rojo");
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
            pantalla.iniciarPantallaInterpol(event, juego);
            sceneActual.setRoot(root);
            stage.setScene(sceneActual);
            stage.setMaximized(true);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
