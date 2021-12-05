package edu.fiuba.algo3.modelo;

public class Ubicacion{
    private int altitud;
    private int latitud;

    public Ubicacion(int altitud, int latitud){
        this.altitud = altitud;
        this.latitud = latitud;
    }

    public int calcularDistancia(Ubicacion ubicacionSiguiente){
        int altitudUbicacionSiguiente = ubicacionSiguiente.altitud;
        int latitudUbicacionSiguiente = ubicacionSiguiente.latitud;

        double x = Math.pow(this.latitud - latitudUbicacionSiguiente, 2);
        double y = Math.pow(this.altitud - altitudUbicacionSiguiente, 2);
        return (int) Math.sqrt(x+y);
    }
}