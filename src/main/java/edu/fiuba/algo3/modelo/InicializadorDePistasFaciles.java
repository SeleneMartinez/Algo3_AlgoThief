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

public class InicializadorDePistasFaciles {

    public HashMap<String, List<PistaFacil>> inicializarPistas() throws FileNotFoundException {

        HashMap<String, List<PistaFacil>> pistasFaciles = new HashMap<String, List<PistaFacil>>();
        JsonStreamParser parser = new JsonStreamParser(new FileReader("src/main/resources/pistasFaciles.json"));
        JsonElement json = parser.next();
        JsonArray jsonArray = json.getAsJsonArray();
        for (int i = 0; i < jsonArray.size(); i++) {
            String nombreCiudad = (jsonArray.get(i).getAsJsonObject().get("Ciudad")).getAsString();
            String pistaEconomica = (jsonArray.get(i).getAsJsonObject().get("PistaEconomica")).getAsString();
            String pistaViajera = (jsonArray.get(i).getAsJsonObject().get("PistaViajera")).getAsString();
            String pistaCultural = (jsonArray.get(i).getAsJsonObject().get("PistaCultural")).getAsString();

            PistaFacil pistaFacilEconomica = new PistaFacil(pistaEconomica);
            PistaFacil pistaFacilViajera = new PistaFacil(pistaViajera);
            PistaFacil pistaFacilCultural = new PistaFacil(pistaCultural);
            List<PistaFacil> pistas = Arrays.asList(pistaFacilEconomica,
                    pistaFacilViajera,
                    pistaFacilCultural);
            pistasFaciles.put(nombreCiudad, pistas);
        }
        return pistasFaciles;
    }
}
