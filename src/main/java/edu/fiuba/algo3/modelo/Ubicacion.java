package edu.fiuba.algo3.modelo;

public class Ubicacion{
    private double altitud;
    private double latitud;

    public Ubicacion(double altitud, double latitud){
        this.altitud = altitud;
        this.latitud = latitud;
    }

    public int calcularDistancia(Ubicacion ubicacionSiguiente){
        double radio_tierra = 6371; //en km

        double altitudUbicacionEnRad = Math.toRadians(this.altitud);
        double latitudUbicacionEnRad = Math.toRadians(this.latitud);
        double altitudUbicacionSiguienteEnRad = Math.toRadians(ubicacionSiguiente.altitud);
        double latitudUbicacionSiguienteEnRad = Math.toRadians(ubicacionSiguiente.latitud);

        return Math.abs((int) (radio_tierra * Math.acos(Math.sin(latitudUbicacionEnRad)) * Math.sin(latitudUbicacionSiguienteEnRad) * Math.cos(latitudUbicacionEnRad) * Math.cos(latitudUbicacionSiguienteEnRad)
                * Math.cos(altitudUbicacionEnRad - altitudUbicacionSiguienteEnRad)));
    }
}