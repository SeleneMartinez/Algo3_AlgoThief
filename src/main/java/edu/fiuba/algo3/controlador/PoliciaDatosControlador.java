package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.Vista.AvisoRobo;
import edu.fiuba.algo3.modelo.Algothief;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;


public class PoliciaDatosControlador {
    Algothief algothief;

    @FXML
    public TextField nombrePolicia;

    public void iniciar(Algothief algothief){
        this.algothief = algothief;
    }

    @FXML
    public void asignarNombre(ActionEvent event) {
        this.algothief.nuevaPartida(nombrePolicia.getText());
        this.proximaPantalla(event);
    }

    public void proximaPantalla(ActionEvent event) {
        try {
            Object eventSource = event.getSource();
            Node sourceAsNode = (Node) eventSource;
            Scene sceneActual = sourceAsNode.getScene();
            Window window = sceneActual.getWindow();
            Stage stage = (Stage) window;
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/avisoRobo.fxml"));
            Parent root = loader.load();
            AvisoRobo controlador = loader.getController();
            controlador.iniciarAvisoRobo(algothief);
            sceneActual.setRoot(root);
            stage.setScene(sceneActual);
            stage.setMaximized(true);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    
}
