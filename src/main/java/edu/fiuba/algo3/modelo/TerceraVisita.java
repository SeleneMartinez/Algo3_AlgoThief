package edu.fiuba.algo3.modelo;

public class TerceraVisita implements IVisita {
    public int demora = 3;

    public IVisita recibirVisita(Policia policia){
        policia.demorar(this.demora);
        return new TerceraVisita();
    }
}
