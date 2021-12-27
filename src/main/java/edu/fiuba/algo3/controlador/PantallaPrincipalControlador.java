package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Algothief;
import edu.fiuba.algo3.modelo.Partida;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class PantallaPrincipalControlador {
    @FXML
    public Text ciudad;

    @FXML
    public Text tiempo;

    public Algothief juego;

    private void modificarTiempo(ActionEvent event) {
        Partida partida = juego.getPartida();
        /**
        if (partida.partidaTerminada()) {
            this.pantallaFinal(event);
        }
         */
        Integer h = partida.getHora();
        String h2 = Integer.toString(h);
        tiempo.setText(partida.getDia() + " " + h2 + " hs");

    }

    public void iniciarPantallaPrincipal(Algothief algothief) {
        juego = algothief;
        Partida partida = juego.getPartida();
        Integer h = partida.getHora();
        String h2 = Integer.toString(h);
        tiempo.setText(partida.getDia() + " " + h2 + " hs");
        ciudad.setText(juego.getPartida().getCiudadActual().darNombre());

    }

    public void pantallaInvestigacion(ActionEvent event){
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

    public void pantallaInterpol(ActionEvent event) {
        try {
            Object eventSource = event.getSource();
            Node sourceAsNode = (Node) eventSource;
            Scene sceneActual = sourceAsNode.getScene();
            Window window = sceneActual.getWindow();
            Stage stage = (Stage) window;
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/pantallaInterpol.fxml"));
            Parent root = loader.load();
            PantallaInterpolControlador controlador = loader.getController();
            controlador.iniciarPantallaInterpol(event, juego);
            sceneActual.setRoot(root);
            stage.setScene(sceneActual);
            stage.setMaximized(true);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
