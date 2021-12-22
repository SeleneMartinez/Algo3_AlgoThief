package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.controlador.PantallaPistas;
import edu.fiuba.algo3.controlador.PoliciaDatosControlador;
import edu.fiuba.algo3.modelo.Algothief;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class AvisoRobo {
    public Algothief juego;

    public void iniciarAvisoRobo(Algothief algothief) {
        juego = algothief;
    }

    public void proximaPantalla(ActionEvent event){
        try {
            Object eventSource = event.getSource();
            Node sourceAsNode = (Node) eventSource;
            Scene sceneActual = sourceAsNode.getScene();
            Window window = sceneActual.getWindow();
            Stage stage = (Stage) window;
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/pantallaPistas.fxml"));
            Parent root = loader.load();
            PantallaPistas controlador = loader.getController();
            controlador.iniciarPantallaPistas(juego);
            sceneActual.setRoot(root);
            stage.setScene(sceneActual);
            stage.setMaximized(true);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}

