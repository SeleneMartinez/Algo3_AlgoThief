package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.Vista.PantallaFinal;
import edu.fiuba.algo3.modelo.Algothief;
import edu.fiuba.algo3.modelo.Ciudad;
import edu.fiuba.algo3.modelo.Partida;
import edu.fiuba.algo3.modelo.Pista;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.util.List;



public class PantallaPistas {
    @FXML
    public Text ciudad;

    @FXML
    public Text pista;

    @FXML
    public Text tiempo;

    public Algothief juego;

    public void iniciarPantallaPistas(Algothief algothief) {
        juego = algothief;
        Partida partida = juego.getPartida();
        Integer h = partida.getHora();
        String h2 = Integer.toString(h);
        tiempo.setText(partida.getDia() + " " + h2 + " hs");
        ciudad.setText(juego.getPartida().getCiudadActual().darNombre());

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


    public void pantallaMatonAtaca(ActionEvent event) {
        try {
            Object eventSource = event.getSource();
            Node sourceAsNode = (Node) eventSource;
            Scene sceneActual = sourceAsNode.getScene();
            Window window = sceneActual.getWindow();
            Stage stage = (Stage) window;
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/matonAtaca.fxml"));
            Parent root = loader.load();
            PantallaMatonAtacaControlador pantalla = loader.getController();
            pantalla.iniciarPantallaMatonAtaca(juego);
            sceneActual.setRoot(root);
            stage.setScene(sceneActual);
            stage.setMaximized(true);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void pantallaLadronEscapa(ActionEvent event) {
        try {
            Object eventSource = event.getSource();
            Node sourceAsNode = (Node) eventSource;
            Scene sceneActual = sourceAsNode.getScene();
            Window window = sceneActual.getWindow();
            Stage stage = (Stage) window;
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/pantallaLadronEscapa.fxml"));
            Parent root = loader.load();
            PantallaLadronEscapoControlador pantalla = loader.getController();
            pantalla.iniciarPantallaLadronEscapo(juego);
            sceneActual.setRoot(root);
            stage.setScene(sceneActual);
            stage.setMaximized(true);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void pantallaPoliciaAtrapaLadron(ActionEvent event) {
        try {
            Object eventSource = event.getSource();
            Node sourceAsNode = (Node) eventSource;
            Scene sceneActual = sourceAsNode.getScene();
            Window window = sceneActual.getWindow();
            Stage stage = (Stage) window;
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/pantallaPoliciaAtrapaLadron.fxml"));
            Parent root = loader.load();
            PantallaPoliciaAtrapaLadronControlador pantalla = loader.getController();
            pantalla.iniciarPantallaPoliciaAtrapaLadron(juego);
            sceneActual.setRoot(root);
            stage.setScene(sceneActual);
            stage.setMaximized(true);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public void detectarRespuesta(String respuesta, ActionEvent event) {
        if (respuesta.equals("Matón atacó al policia")) {
            this.pantallaMatonAtaca(event);
        } else if (respuesta.equals("Ladrón escapó")) {
            this.pantallaLadronEscapa(event);
        } else if (respuesta.equals("Policia atrapó al ladron")) {
            this.pantallaPoliciaAtrapaLadron(event);
        } else {
            pista.setText("La pista es:" + "\n" + respuesta);
        }
    }


    public void getPistaEconomica(ActionEvent event) {
        Partida partida = juego.getPartida();
        Ciudad ciudadActual = partida.getCiudadActual();
        String respuesta = ciudadActual.devolverEdificios().get(0).visitarEdificio(partida.getPolicia()).obtenerRespuesta();
        this.detectarRespuesta(respuesta, event);
        //pista.setText("La pista es:" + "\n" + respuesta);
        this.modificarTiempo(event);
    }

    public void getPistaViajera(ActionEvent event) {
        Partida partida = juego.getPartida();
        Ciudad ciudadActual = partida.getCiudadActual();
        String respuesta = ciudadActual.devolverEdificios().get(1).visitarEdificio(partida.getPolicia()).obtenerRespuesta();
        //pista.setText("La pista es:" + "\n" + respuesta);
        this.detectarRespuesta(respuesta, event);
        this.modificarTiempo(event);
    }

    public void getPistaCultural(ActionEvent event) {
        Partida partida = juego.getPartida();
        Ciudad ciudadActual = partida.getCiudadActual();
        String respuesta = ciudadActual.devolverEdificios().get(2).visitarEdificio(partida.getPolicia()).obtenerRespuesta();
        this.detectarRespuesta(respuesta, event);
        //pista.setText("La pista es:" + "\n" + ciudadActual.devolverEdificios().get(2).visitarEdificio(partida.getPolicia()).obtenerRespuesta());
        this.modificarTiempo(event);
    }



}

