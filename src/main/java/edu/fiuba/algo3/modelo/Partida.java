package edu.fiuba.algo3.modelo;

import java.io.FileNotFoundException;
import java.util.*;

public class Partida {
    Ladron ladron;
    Policia policia;
    List<Ciudad> ciudades;
    List<Ciudad> ciudadesNoConectadas;
    HashMap<String, List<Pista>> pistasPorCiudad;
    Ciudad ciudadActual;
    Ciudad ciudadAnterior;
    BuscadorLadrones buscador;

    /**
    public Partida(){

    }
    public Partida(Policia policia, List<Ciudad> ciudades, Ladron ladron){
        this.ladron = ladron;
        this.policia = policia;
        this.ciudades = ciudades;
    }
    */
    public Partida(String nombrePolicia, List<Ciudad> ciudades, Ladron ladron) {
        policia = new Policia(nombrePolicia);
        //this.policia = policia;
        this.ladron = ladron;
        this.ciudades = ciudades;

        this.ciudadesNoConectadas = new ArrayList<Ciudad>(this.ciudades);
        IRango rango = policia.obtenerRangoPolicia();
        //HashMap<String, List<Pista>> pistasPorCiudad = rango.obtenerPistaPorRango();
        pistasPorCiudad = rango.obtenerPistaPorRango();
        this.setPistasEnCiudad(pistasPorCiudad);
        this.obtenerRutaLadron();
        this.ciudadActual = this.obtenerCiudadRandom();
        this.ciudadAnterior = this.obtenerCiudadRandom();
        this.conectarCiudad();
    }

    public List<Ciudad> getConexiones(){
        return this.ciudadActual.getConexiones();
    }

    public Ciudad obtenerCiduadAnterior(){
        return this.ciudadAnterior;
    }

    private void obtenerRutaLadron(){
        IRutaDeEscape ruta = this.policia.obtenerTipoDeRuta();
        ruta.crearRuta(ciudades);
        ladron.agregarRutaEscape(ruta);
    }
    private Ciudad obtenerCiudadRandom(){
        int numeroRandom = (new Random()).nextInt(this.ciudadesNoConectadas.size());

        if( this.ciudadesNoConectadas.get(numeroRandom).equals(ciudadActual)){
            return this.obtenerCiudadRandom();
        }
        else{
            return this.ciudadesNoConectadas.get(numeroRandom);
        }
    }

    public int obtenerTiempoDeViaje(Ciudad ciudad){
        return policia.obtenerTiempoDeViaje(ciudadActual, ciudad);
    }

    private void conectarCiudad(){
        ciudadActual.agregarConexion(ciudadAnterior);
        ciudadActual.agregarConexion(obtenerCiudadRandom());
        ciudadActual.agregarConexion(obtenerCiudadRandom());

    }
    private void setPistasEnCiudad(HashMap<String, List<Pista>> pistas){
        Random random = new Random();
        ciudadActual = ciudades.get(random.nextInt(ciudades.size()));
        //ConectorCiudades conexiones = new ConstructorCiudades(ciudades);
        for (Ciudad ciudad : this.ciudades) {
            //conexiones.agregarConexiones(ciudad)
            List<Pista> pista = pistas.get(ciudad.darNombre());
            for (int i = 0; i < 3; i++) {
                if (i == 0) {
                    ciudad.agregarEdificio(new Banco(pista.get(i)));
                } else if (i == 1) {
                    ciudad.agregarEdificio(new Aeropuerto(pista.get(i)));
                } else {
                    ciudad.agregarEdificio(new Biblioteca(pista.get(i)));
                }
            }
        }
        //RutaFacil ruta = new RutaFacil(ciudadActual);
        //ladron.agregarRutaEscape(ruta);
        
    }
    public void viajar(Ciudad ciudadDestino){
        this.policia.viajarDesdeHasta(ciudadActual, ciudadDestino);
        ciudadAnterior = ciudadActual;
        ciudadActual = ciudadDestino;
        this.conectarCiudad();
    }
    
    public void asignarBuscador(List<Ladron> ladrones) {
        buscador = new BuscadorLadrones(ladrones);
    }
    
    public void buscadorAsignarPelo(String color) {
        buscador.buscarPorPelo(color);
    }

    public void buscadorAsignarHobby(String hobby) {
        buscador.buscarPorHobby(hobby);
    }

    public void buscadorAsignarSexo(String sexo) {
        buscador.buscarPorSexo(sexo);
    }

    public void buscadorAsignarCaracteristica(String caracteristica) {
        buscador.buscarPorCaracteristica(caracteristica);
    }

    public void buscadorAsignarVehiculo(String vehiculo) {
        buscador.buscarPorVehiculo(vehiculo);
    }

    public List<Ladron> buscadorDevuelveSospechosos() {
        return buscador.devolverSospechosos();
    }

    public void reiniciarBusqueda() {
        buscador.reiniciarBusqueda();
    }

    
    public String getDia() {
        return policia.obtenerDia();
    }

    public int getHora() {
        return policia.obtenerHora();
    }

    public Ciudad getCiudadActual() {
        return ciudadActual;
    }

    public Policia getPolicia() {
        return policia;
    }
    
    public boolean partidaTerminada() {
        return policia.finTiempo();
    }

}
