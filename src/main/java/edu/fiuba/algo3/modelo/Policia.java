package edu.fiuba.algo3.modelo;

import java.io.FileNotFoundException;

public class Policia {
    public String nombre;
    private int casosResueltos;
    private IRango rango;
    private IOrdenDeCaptura orden;
    private Reloj reloj;

    public Policia(String nombre) {
        this.nombre = nombre;
        this.casosResueltos = 0;
        this.rango = new RangoNovato();
        this.reloj = new Reloj(0 , "Lunes");
        this.orden = new OrdenDeCapturaSinEmitir();
    }

    public int obtenerTiempoDeViaje(Ciudad ciudadOrigen, Ciudad ciudadDestino){
        return this.rango.tiempoDeViaje(ciudadOrigen, ciudadDestino);
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
    
    public IRutaDeEscape obtenerTipoDeRuta(){
        return this.rango.obtenerRutaDeEscapeSegunRango();
    }

    public void dormir(){
        reloj.aumentarHora(8);
    }

    public void investigacionInterpol() {
        reloj.aumentarHora(3);
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
    public String obtenerDia() { return reloj.obtenerDia(); }
    
    public boolean finTiempo() {
        return reloj.tiempoTerminado();
    }
}



