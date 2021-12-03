package edu.fiuba.algo3.modelo;

import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;


public class PistaFacil extends Pista {
    public String laPista;

    public PistaFacil(String tipoEdificio, String ciudad) {
        try {
            BufferedReader csvReader = new BufferedReader(new FileReader("src/main/java/edu/fiuba/algo3/modelo/pistas.csv"));
            String linea;
            while ((linea = csvReader.readLine()) != null) {
                String[] datosPista = linea.split(";");
                if (datosPista[0].equals(ciudad) && datosPista[1].equals("facil") && datosPista[2].equals(tipoEdificio)) {
                    laPista = datosPista[3];
                }
            }
            csvReader.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public String obtenerRespuesta() {
        return laPista;
    };
}
