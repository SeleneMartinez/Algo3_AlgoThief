package edu.fiuba.algo3.modelo;

public class SegundaVisita implements IVisita {
    public int demora = 2;

    public IVisita recibirVisita(Policia policia){
        policia.demorar(this.demora);
        return new TerceraVisita();
    }
}
