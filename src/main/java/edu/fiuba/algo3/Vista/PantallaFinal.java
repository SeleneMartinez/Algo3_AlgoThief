package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.controlador.InicioControlador;
import edu.fiuba.algo3.controlador.PoliciaDatosControlador;
import edu.fiuba.algo3.modelo.Algothief;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.File;
import java.io.IOException;

public class PantallaFinal {

    public Algothief algothief;

    public void iniciarPantallaFinal(Algothief juego) {
        algothief = juego;
    }

    public void volverEmpezar(ActionEvent event) {
        try {
            reproducirSonidoInicio();
            Object eventSource = event.getSource();
            Node sourceAsNode = (Node) eventSource;
            Scene sceneActual = sourceAsNode.getScene();
            Window window = sceneActual.getWindow();
            Stage stage = (Stage) window;
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/main.fxml"));
            Parent root = loader.load();
            InicioControlador inicioControlador = loader.getController();
            inicioControlador.iniciar(algothief);
            sceneActual.setRoot(root);
            stage.setScene(sceneActual);
            stage.setMaximized(true);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void reproducirSonidoInicio(){
        File archivo = new File("src/main/resources/inicio.mp3");
        Media audio = new Media(archivo.toURI().toString());
        MediaPlayer audioInicio = new MediaPlayer(audio);
        audioInicio.setCycleCount(MediaPlayer.INDEFINITE);
        audioInicio.setVolume(0.06);
        audioInicio.play();
    }

}
