package model.observer;

import model.state.Comanda;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Notificare implements Subiect, Serializable {
    List<Observer> lista;

    public Notificare(){
        lista=new ArrayList<>();
    }
    @Override
    public void adaugaObserver(Observer observer) {
        if(!lista.contains(observer)){
            lista.add(observer);
        }
    }

    @Override
    public void stergeObserver(Observer observer) {
        if(lista.contains(observer))
            lista.remove(observer);

    }

    @Override
    public void notificaAbonati(Comanda comanda) {
        for (Observer obs: lista){
            obs.primesteNotificare(comanda);
        }
    }
}
