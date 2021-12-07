package edu.fiuba.algo3.modelo;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonStreamParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class InicializadorLadrones {

    public List<Ladron> iniciarLadrones() {
        List<Ladron> ladrones = new ArrayList<Ladron>();
        try{
            JsonStreamParser parser = new JsonStreamParser(new FileReader("src/main/resources/ladrones.json"));
            JsonElement json = parser.next();
            JsonArray jsonArray = json.getAsJsonArray();
            for (int i = 0; i < jsonArray.size(); i++) {
                JsonObject obj = jsonArray.get(i).getAsJsonObject();
                String nombre = obj.get("Nombre").getAsString();
                String hobby = obj.get("Hobby").getAsString();
                String pelo = obj.get("Pelo").getAsString();
                String auto = obj.get("Auto").getAsString();
                String caracteristica = obj.get("Caracteristica").getAsString();
                String sexo = obj.get("Sexo").getAsString();

                Ladron ladronNuevo = new Ladron(nombre, pelo, sexo, hobby, caracteristica, auto);
                ladrones.add(ladronNuevo);
            }
        }catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }
        return ladrones;
    }
}
