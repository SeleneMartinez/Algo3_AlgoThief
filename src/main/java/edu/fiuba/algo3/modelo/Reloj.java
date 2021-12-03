package edu.fiuba.algo3.modelo;

public class Reloj {
    private int horario= 7;
    private String dia= 'Lunes';

    public Reloj (int horario, String dia){
        this.horario=horario;
        this.dia=dia;
    }
    public void aumentarHora( int hora){
        this.horario= this.horario+hora;
    }
}
