package edu.fiuba.algo3.modelo;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonStreamParser;
import edu.fiuba.algo3.modelo.Algothief;
import edu.fiuba.algo3.modelo.Ubicacion;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException{
        Algothief algothief = new Algothief();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/main.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root, 500, 500);
        scene.setFill(Color.BLACK);
        stage.setTitle("AlgoThief G13");

        stage.setMinHeight(720);
        stage.setMinWidth(1080);
        stage.setMaximized(true);
        stage.setScene(scene);
        stage.show();
    }

    public static <AlgoThief> void main(String[] args){
        Algothief algothief = new Algothief();
        launch();
    }
}
