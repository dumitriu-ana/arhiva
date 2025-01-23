package model.observer;

import model.state.Comanda;

public interface Subiect {
    void adaugaObserver(Observer observer);
    void stergeObserver(Observer observer);
    void notificaAbonati(Comanda comanda);
}
