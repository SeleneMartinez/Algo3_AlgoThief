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
        this.reloj = new Reloj(7 , "Lunes");
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

    public void dormir(){
        reloj.aumentarHora(8);
    }

    public void nuevoCasoResuelto()
    {
        this.casosResueltos++;
        this.rango = this.rango.obtenerRango(casosResueltos);
    }
    public IRespuestaDelEvento detener(Ladron ladron) {
        return this.orden.capturar(ladron);
    }

    public void recibirOrdenDeCaptura(OrdenDeCaptura ordenDeCaptura){
        this.orden = ordenDeCaptura;
        this.demorarPorOrdenDeCaptura();
    }

    private void demorarPorOrdenDeCaptura() {
        this.demorar(3);
    }

    public void viajarDesdeHasta(Ciudad origen, Ciudad destino){
        this.demorar(this.rango.tiempoDeViaje(origen, destino));
    }

    public int obtenerHora(){
        return reloj.obtenerHora();
    }
}



