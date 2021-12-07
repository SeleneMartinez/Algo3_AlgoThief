package edu.fiuba.algo3.modelo;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonStreamParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class InicializadorDePistasDificiles {

    public HashMap<String, List<Pista>> inicializarPistas() {

        HashMap<String, List<Pista>> pistasFaciles = new HashMap<String, List<Pista>>();
        try{
            JsonStreamParser parser = new JsonStreamParser(new FileReader("src/main/resources/pistasDificiles.json"));
            JsonElement json = parser.next();
            JsonArray jsonArray = json.getAsJsonArray();
            for (int i = 0; i < jsonArray.size(); i++) {
                String nombreCiudad = (jsonArray.get(i).getAsJsonObject().get("Ciudad")).getAsString();
                String pistaEconomica = (jsonArray.get(i).getAsJsonObject().get("PistaEconomica")).getAsString();
                String pistaViajera = (jsonArray.get(i).getAsJsonObject().get("PistaViajera")).getAsString();
                String pistaCultural = (jsonArray.get(i).getAsJsonObject().get("PistaCultural")).getAsString();

                Pista pistaFacilEconomica = new Pista(pistaEconomica);
                Pista pistaFacilViajera = new Pista(pistaViajera);
                Pista pistaFacilCultural = new Pista(pistaCultural);
                List<Pista> pistas = Arrays.asList(pistaFacilEconomica,
                        pistaFacilViajera,
                        pistaFacilCultural);
                pistasFaciles.put(nombreCiudad, pistas);
            }
        }catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        }
        return pistasFaciles;
    }
}


