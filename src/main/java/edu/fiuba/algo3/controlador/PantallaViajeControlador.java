package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.Vista.PantallaFinal;
import edu.fiuba.algo3.modelo.Algothief;
import edu.fiuba.algo3.modelo.Ciudad;
import edu.fiuba.algo3.modelo.Partida;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class PantallaViajeControlador {
    Algothief juego;

    Ciudad ciudadAnterior;
    Ciudad ciudadPrimeraConexion;
    Ciudad ciudadSegundaConexion;
    @FXML
    public Text tiempo;
    @FXML
    public Button anterior;
    @FXML
    public Button segundaConexion;
    @FXML
    public Button primeraConexion;
    @FXML
    public Text tiempoDeViaje1;
    @FXML
    public Text tiempoDeViaje2;
    @FXML
    public Text tiempoDeViaje3;

    public void iniciarPantallaViaje(Algothief algothief) {
        juego = algothief;
        Partida partida = juego.getPartida();
        Integer h = partida.getHora();
        String h2 = Integer.toString(h);
        tiempo.setText(partida.getDia() + " " + h2 + " hs");

        List<Integer> indexes = new ArrayList<Integer>(Arrays.asList(0,1,2));
        int random1 =indexes.remove((new Random()).nextInt(3));
        int random2= indexes.remove((new Random()).nextInt(2));
        int random3 = indexes.remove(0);
        ciudadAnterior = partida.getConexiones().get(random1);
        ciudadPrimeraConexion = partida.getConexiones().get(random2);
        ciudadSegundaConexion = partida.getConexiones().get(random3);
        anterior.setText(ciudadAnterior.darNombre());
        primeraConexion.setText(ciudadPrimeraConexion.darNombre());
        segundaConexion.setText(ciudadSegundaConexion.darNombre());
        tiempoDeViaje1.setText(String.format("Viaje de %d hrs",(partida.obtenerTiempoDeViaje(ciudadAnterior))));
        tiempoDeViaje2.setText(String.format("Viaje de %d hrs", partida.obtenerTiempoDeViaje(ciudadPrimeraConexion)));
        tiempoDeViaje3.setText(String.format("Viaje de %d hrs",partida.obtenerTiempoDeViaje(ciudadSegundaConexion)));

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

    public void volver(ActionEvent event) {
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

    public void viajarAnterior(ActionEvent event){
        Partida partida = juego.getPartida();
        partida.viajar(ciudadAnterior);
        this.modificarTiempo(event);
        this.volver(event);
    }
    public void viajarPrimera(ActionEvent event){
        Partida partida = juego.getPartida();
        partida.viajar(ciudadPrimeraConexion);
        this.modificarTiempo(event);
        this.volver(event);
    }
    public void viajarSegunda(ActionEvent event){
        Partida partida = juego.getPartida();
        partida.viajar(ciudadSegundaConexion);
        this.modificarTiempo(event);
        this.volver(event);
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
}
