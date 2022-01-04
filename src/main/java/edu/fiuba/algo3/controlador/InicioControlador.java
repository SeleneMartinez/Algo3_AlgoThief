package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Algothief;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class InicioControlador {
    Algothief algothief;
    private FXML vista;

    public void iniciar(Algothief algothief){
        this.algothief = algothief;
    }

    @FXML
    public void comenzar(ActionEvent event){
            this.algothief.iniciarJuego();
            this.proximaPantalla(event);

    }
    public void proximaPantalla(ActionEvent event){
        try {
            Object eventSource = event.getSource();
            Node sourceAsNode = (Node) eventSource;
            Scene sceneActual = sourceAsNode.getScene();
            Window window = sceneActual.getWindow();
            Stage stage = (Stage) window;
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/policiaDatos.fxml"));
            Parent root = loader.load();
            sceneActual.setRoot(root);
            stage.setScene(sceneActual);
            stage.setMaximized(true);
            stage.show();
            PoliciaDatosControlador policiaDatosControlador = loader.getController();
            policiaDatosControlador.iniciar(this.algothief);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
