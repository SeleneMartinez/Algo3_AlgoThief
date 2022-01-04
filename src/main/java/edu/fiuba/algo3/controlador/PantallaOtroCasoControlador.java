package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.Vista.AvisoRobo;
import edu.fiuba.algo3.modelo.Algothief;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class PantallaOtroCasoControlador {
    public Algothief juego;

    public void iniciarPantallaOtroCaso(Algothief algothief) {
        juego = algothief;
    }

    public void nuevoCaso(ActionEvent event) {
        try {
            juego.nuevoCaso();
            Object eventSource = event.getSource();
            Node sourceAsNode = (Node) eventSource;
            Scene sceneActual = sourceAsNode.getScene();
            Window window = sceneActual.getWindow();
            Stage stage = (Stage) window;
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/avisoRobo.fxml"));
            Parent root = loader.load();
            AvisoRobo controlador = loader.getController();
            controlador.iniciarAvisoRobo(juego);
            sceneActual.setRoot(root);
            stage.setScene(sceneActual);
            stage.setMaximized(true);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void volverEmpezar(ActionEvent event) {
        try {
            Object eventSource = event.getSource();
            Node sourceAsNode = (Node) eventSource;
            Scene sceneActual = sourceAsNode.getScene();
            Window window = sceneActual.getWindow();
            Stage stage = (Stage) window;
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/main.fxml"));
            Parent root = loader.load();
            InicioControlador inicioControlador = loader.getController();
            inicioControlador.iniciar(juego);
            sceneActual.setRoot(root);
            stage.setScene(sceneActual);
            stage.setMaximized(true);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
