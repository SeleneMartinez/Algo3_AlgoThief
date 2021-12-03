package edu.fiuba.algo3.modelo;

public class Policia {
    public String nombre;
    private int casosResueltos;
    private Rango rango;
    private int cantEdificiosVisitados;
    private OrdenDeCaptura orden;

    public Policia(String nombre, int casosResueltos) {
        this.nombre = nombre;
        this.casosResueltos = casosResueltos;
        this.rangoSiguiente();
    }

    public Policia(String nombre){
        this.nombre = nombre;
        this.casosResueltos = 0;
        this.rango = new RangoNovato();
        this.orden = null;
    }

    public String obtenerNombre() {
        return this.nombre;
    }

    public int cantidadDeCasosResueltos() {
        return this.casosResueltos;
    }

    public void rangoSiguiente() {
        if (this.casosResueltos < 5) {
            this.rango = new RangoNovato();
        } else if (5 <= this.casosResueltos && this.casosResueltos < 10){
            this.rango = new RangoDetective();
        } else if (10 <= this.casosResueltos && this.casosResueltos < 20){
            this.rango = new RangoInvestigador();
        } else if (20 <= this.casosResueltos){
            this.rango = new RangoSargento();
        }
    }

    public Rango obtenerRangoPolicia() {
        return this.rango;
    }

    public void demorar(int demora){
        Reloj.aumentarHora(demora);
    }

}



