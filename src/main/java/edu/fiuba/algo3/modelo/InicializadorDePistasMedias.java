package edu.fiuba.algo3.modelo;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonStreamParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class InicializadorDePistasMedias {

    public HashMap<String, List<Pista>> inicializarPistas() {

        HashMap<String, List<Pista>> pistasMedias = new HashMap<String, List<Pista>>();
        try{
            JsonStreamParser parser = new JsonStreamParser(new FileReader("src/main/resources/pistasMedias.json"));
            JsonElement json = parser.next();
            JsonArray jsonArray = json.getAsJsonArray();
            for (int i = 0; i < jsonArray.size(); i++) {
                String nombreCiudad = (jsonArray.get(i).getAsJsonObject().get("Ciudad")).getAsString();
                String pistaEconomica = (jsonArray.get(i).getAsJsonObject().get("PistaEconomica")).getAsString();
                String pistaViajera = (jsonArray.get(i).getAsJsonObject().get("PistaViajera")).getAsString();
                String pistaCultural = (jsonArray.get(i).getAsJsonObject().get("PistaCultural")).getAsString();

                Pista pistaMediaEconomica = new Pista(pistaEconomica);
                Pista pistaMediaViajera = new Pista(pistaViajera);
                Pista pistaMediaCultural = new Pista(pistaCultural);
                List<Pista> pistas = Arrays.asList(pistaMediaEconomica,
                        pistaMediaViajera,
                        pistaMediaCultural);
                pistasMedias.put(nombreCiudad, pistas);
            }
        }catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }
        return pistasMedias;
    }
}


