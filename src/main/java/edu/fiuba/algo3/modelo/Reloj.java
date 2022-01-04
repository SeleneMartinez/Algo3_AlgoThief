package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Reloj {

    List <String> dias = new ArrayList<String>(Arrays.asList(
                                                             "Martes",
                                                             "Miercoles",
                                                             "Jueves",
                                                             "Viernes",
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
        if (nuevoHorario >= 22) {
            this.horario = nuevoHorario - 16;
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
    
    public boolean tiempoTerminado() {
        return dia.equals("Domingo") && horario >= 17;
    }

    public void reiniciarReloj() {
        iteradorDias = dias.iterator();
        horario= 7;
        dia= "Lunes";
    }
}
