package edu.fiuba.algo3.modelo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.*;
public class InicializadorCiudades {

    public InicializadorCiudades() {}

    public List<Ciudad> iniciarCiudades() throws FileNotFoundException {
        List<Ciudad> ciudades = new ArrayList<>();
        JsonStreamParser parser = new JsonStreamParser(new FileReader("C:\\Users\\smartinez\\Documents\\Algoritmos\\Algo3_AlgoThief\\src\\main\\resources\\ciudades.json"));
        JsonElement json =  parser.next();
        JsonArray jsonArray = json.getAsJsonArray();
        for (int i = 0; i < jsonArray.size(); i++) {
            String nombreCiudad = (jsonArray.get(i).getAsJsonObject().get("Ciudad")).getAsString();
            String pais = (jsonArray.get(i).getAsJsonObject().get("Pais")).getAsString();
            int latitud = (jsonArray.get(i).getAsJsonObject().get("latitud")).getAsInt();
            int altitud = (jsonArray.get(i).getAsJsonObject().get("altitud")).getAsInt();

            Ubicacion ubicacion = new Ubicacion(altitud,latitud);
            Ciudad nuevaCiudad = new Ciudad(nombreCiudad,ubicacion);
            ciudades.add(nuevaCiudad);
        }
        return ciudades;
    }
}
