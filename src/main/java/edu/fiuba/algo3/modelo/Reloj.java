package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Reloj {

    List <String> dias = new ArrayList<String>(Arrays.asList("Lunes",
                                                             "Martes",
                                                             "Miercoles",
                                                             "Jueves",
                                                             "Viermes",
                                                             "Sabado",
                                                             "Domingo"));
    Iterator <String> iteradorDias= dias.iterator();
    private int horario= 7;
    private String dia= "Lunes";

    public Reloj (int horario, String dia){
        this.horario=horario;
        this.dia=dia;
    }
    public void aumentarHora( int hora){
        int nuevoHorario = this.horario + hora;
        if (nuevoHorario >= 24) {
            this.horario = nuevoHorario - 24;
            this.cambioDia();
        } else {
            this.horario = nuevoHorario;
        }
    }
    public void cambioDia(){
        this.dia=iteradorDias.next();
    }

    public int obtenerHora(){
        return this.horario;
    }
    public String obtenerDia() { return this.dia; }
}
