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

public class PantallaPoliciaAtrapaLadronControlador {
    public Algothief juego;

    public void iniciarPantallaPoliciaAtrapaLadron(Algothief algothief) {
        juego = algothief;
    }

    public void policiaAtrapoLadron() {
        juego.getPartida().getPolicia().nuevoCasoResuelto();
    }

    public void continuar(ActionEvent event) {
        try {
            this.policiaAtrapoLadron();
            Object eventSource = event.getSource();
            Node sourceAsNode = (Node) eventSource;
            Scene sceneActual = sourceAsNode.getScene();
            Window window = sceneActual.getWindow();
            Stage stage = (Stage) window;
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/pantallaOtroCaso.fxml"));
            Parent root = loader.load();
            PantallaOtroCasoControlador pantalla = loader.getController();
            pantalla.iniciarPantallaOtroCaso(juego);
            sceneActual.setRoot(root);
            stage.setScene(sceneActual);
            stage.setMaximized(true);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
