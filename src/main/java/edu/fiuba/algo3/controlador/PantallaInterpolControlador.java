package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.Vista.PantallaFinal;
import edu.fiuba.algo3.controlador.PistaPeloControlador;
import edu.fiuba.algo3.modelo.Algothief;
import edu.fiuba.algo3.modelo.Ladron;
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
import java.util.List;

public class PantallaInterpolControlador {
    @FXML
    public Text nombreSospechosos;

    @FXML
    public Text tiempo;

    public Algothief juego;

    public void iniciarPantallaInterpol(Algothief algothief) {
        juego = algothief;
        nombreSospechosos.setText("SIN SOSPECHOSOS");
        Partida partida = juego.getPartida();
        Integer h = partida.getHora();
        String h2 = Integer.toString(h);
        tiempo.setText(partida.getDia() + " " + h2 + " hs");
    }

    private void modificarTiempo(ActionEvent event) {
        Partida partida = juego.getPartida();
        if (partida.partidaTerminada()) {
            this.pantallaFinal(event);
        }
        Integer h = partida.getHora();
        String h2 = Integer.toString(h);
        tiempo.setText(partida.getDia() + " " + h2 + " hs");

    }

    private void pantallaFinal(ActionEvent event) {
        try {
            Object eventSource = event.getSource();
            Node sourceAsNode = (Node) eventSource;
            Scene sceneActual = sourceAsNode.getScene();
            Window window = sceneActual.getWindow();
            Stage stage = (Stage) window;
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/pantallaFinal.fxml"));
            Parent root = loader.load();
            PantallaFinal pantalla = loader.getController();
            pantalla.iniciarPantallaFinal(juego);
            sceneActual.setRoot(root);
            stage.setScene(sceneActual);
            stage.setMaximized(true);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void pistaPelo(ActionEvent event) {
        try {
            Object eventSource = event.getSource();
            Node sourceAsNode = (Node) eventSource;
            Scene sceneActual = sourceAsNode.getScene();
            Window window = sceneActual.getWindow();
            Stage stage = (Stage) window;
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/pistaPelo.fxml"));
            Parent root = loader.load();
            PistaPeloControlador pantalla = loader.getController();
            pantalla.iniciarPantallaPistaPelo(juego);
            sceneActual.setRoot(root);
            stage.setScene(sceneActual);
            stage.setMaximized(true);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void pistaHobby(ActionEvent event) {
        try {
            Object eventSource = event.getSource();
            Node sourceAsNode = (Node) eventSource;
            Scene sceneActual = sourceAsNode.getScene();
            Window window = sceneActual.getWindow();
            Stage stage = (Stage) window;
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/pistaHobby.fxml"));
            Parent root = loader.load();
            PistaHobbyControlador pantalla = loader.getController();
            pantalla.iniciarPantallaPistaHobby(juego);
            sceneActual.setRoot(root);
            stage.setScene(sceneActual);
            stage.setMaximized(true);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void mostrarSospechosos(ActionEvent event) {
        Partida partida = juego.getPartida();
        List<Ladron> sospechosos = partida.buscadorDevuelveSospechosos();
        String lineaTexto = "";
        for (Ladron ladron: sospechosos) {
            lineaTexto = lineaTexto + "* " + ladron.getNombre() + "\n";
        }
        nombreSospechosos.setText(lineaTexto);
        partida.getPolicia().investigacionInterpol();
        this.modificarTiempo(event);


    }

    public void reiniciarBusqueda(ActionEvent event) {
        juego.getPartida().reiniciarBusqueda();
        nombreSospechosos.setText("SIN SOSPECHOSOS");
    }



    public void volverPantallaPrincipal(ActionEvent event) {
        try {
            Object eventSource = event.getSource();
            Node sourceAsNode = (Node) eventSource;
            Scene sceneActual = sourceAsNode.getScene();
            Window window = sceneActual.getWindow();
            Stage stage = (Stage) window;
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/pantallaPrincipal.fxml"));
            Parent root = loader.load();
            PantallaPrincipalControlador pantalla = loader.getController();
            pantalla.iniciarPantallaPrincipal(juego);
            sceneActual.setRoot(root);
            stage.setScene(sceneActual);
            stage.setMaximized(true);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }





}
