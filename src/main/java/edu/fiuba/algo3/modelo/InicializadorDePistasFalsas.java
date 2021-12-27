package edu.fiuba.algo3.modelo;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonStreamParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class InicializadorDePistasFalsas {
    public HashMap<String, List<Pista>> inicializarPistas() {

        HashMap<String, List<Pista>> pistasFalsas = new HashMap<String, List<Pista>>();
        List<Pista> pistasEconomica = new ArrayList<>();
        List<Pista> pistasViajera = new ArrayList<>();
        List<Pista> pistasCultural = new ArrayList<>();
        try{
            JsonStreamParser parser = new JsonStreamParser(new FileReader("src/main/resources/pistasDificiles.json"));
            JsonElement json = parser.next();
            JsonArray jsonArray = json.getAsJsonArray();
            for (int i = 0; i < jsonArray.size(); i++) {
                String pistaEconomica = (jsonArray.get(i).getAsJsonObject().get("PistaEconomica")).getAsString();
                String pistaViajera = (jsonArray.get(i).getAsJsonObject().get("PistaViajera")).getAsString();
                String pistaCultural = (jsonArray.get(i).getAsJsonObject().get("PistaCultural")).getAsString();

                Pista pistaFacilEconomica = new Pista(pistaEconomica);
                Pista pistaFacilViajera = new Pista(pistaViajera);
                Pista pistaFacilCultural = new Pista(pistaCultural);
                pistasEconomica.add(pistaFacilEconomica);
                pistasCultural.add(pistaFacilCultural);
                pistasViajera.add(pistaFacilViajera);
            }
        }catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        }
        pistasFalsas.put("PistasEconomicas", pistasEconomica);
        pistasFalsas.put("PistasCulturales", pistasCultural);
        pistasFalsas.put("PistasViajeras", pistasViajera);
        return pistasFalsas;
    }
}


