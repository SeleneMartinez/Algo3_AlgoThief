package edu.fiuba.algo3.modelo;

import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;


public class PistaFacil extends Pista {
    public String laPista;

    public PistaFacil(String pista) {
        this.laPista = pista;
    }

    public String obtenerRespuesta() {
        return laPista;
    };
}
