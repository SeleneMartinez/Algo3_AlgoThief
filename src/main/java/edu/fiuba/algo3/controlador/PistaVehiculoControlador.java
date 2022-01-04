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

public class PistaVehiculoControlador {
    public Algothief juego;

    public void iniciarPantallaPistaVehiculo(Algothief algothief) {
        juego = algothief;
    }

    public void vehiculoMoto(ActionEvent event) {
        juego.getPartida().buscadorAsignarVehiculo("Moto");
        this.volverPantallaInterpol(event);
    }

    public void vehiculoConvertible(ActionEvent event) {
        juego.getPartida().buscadorAsignarVehiculo("Convertible");
        this.volverPantallaInterpol(event);
    }

    public void vehiculoLimosina(ActionEvent event) {
        juego.getPartida().buscadorAsignarVehiculo("Limosina");
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
