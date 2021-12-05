package edu.fiuba.algo3.modelo;

public class Policia {
    public String nombre;
    private int casosResueltos;
    private IRango rango;
    private IOrdenDeCaptura orden;
    private Reloj reloj;

    public Policia(String nombre){
        this.nombre = nombre;
        this.casosResueltos = 0;
        this.rango = new RangoNovato();
        this.reloj = new Reloj(0 , "Lunes");
        this.orden = null;
    }

    public String obtenerNombre() {
        return this.nombre;
    }

    public int cantidadDeCasosResueltos() {
        return this.casosResueltos;
    }

    public IRango obtenerRangoPolicia() {
        return this.rango;
    }

    public void demorar(int demora){
        reloj.aumentarHora(demora);
    }

    public void herir(int herida) { reloj.aumentarHora(herida); }

    public void dormir(){
        reloj.aumentarHora(8);
    }

    public void nuevoCasoResuelto()
    {
        this.casosResueltos++;
        this.rango = this.rango.obtenerRango(casosResueltos);
    }

    /*public void visitarEdificio(){
        return;
    }
    */
    public IRespuestaDelEvento detener(Ladron ladron) {
        return this.orden.capturar(ladron);
    }
}



