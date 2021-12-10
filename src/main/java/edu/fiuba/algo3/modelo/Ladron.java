package edu.fiuba.algo3.modelo;

public class Ladron{
    public String nombre;
    public String sexo;
    public String hobby;
    public String pelo;
    public String auto;
    public String caracteristica;
    public IRutaDeEscape rutaDeEscape;

    public Ladron(String nombre, String pelo, String sexo, String hobby, String caracteristica, String auto){
        this.nombre = nombre;
        this.pelo = pelo;
        this.caracteristica = caracteristica;
        this.hobby = hobby;
        this.auto = auto;
        this.sexo = sexo;
    }

    public IRespuestaDelEvento entregarse(){
        return new LadronAtrapado();
    }

    public IRespuestaDelEvento escapar()
    {
        return new LadronEscapo();
    }

    public String getSexo() {
        return sexo;
    }

    public String getPelo() {
        return pelo;
    }

    public String getCaracteristica() {
        return caracteristica;
    }

    public String getHobby() {
        return hobby;
    }

    public String getVehiculo() {
        return auto;
    }

    public String getNombre() {
        return nombre;
    }

}