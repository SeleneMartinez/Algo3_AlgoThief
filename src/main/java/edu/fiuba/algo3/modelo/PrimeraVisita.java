package edu.fiuba.algo3.modelo;

public class PrimeraVisita implements IVisita{
    int demora = 1;
    public IVisita recibirVisita(Policia policia){
        policia.demorar(this.demora);
        return new SegundaVisita();
    }
}
