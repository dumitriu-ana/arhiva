package controller;

import model.observer.Client;
import model.state.Comanda;
import view.View;

public class Controller {
    private Comanda comanda;
    private View view;

    public Controller(Comanda c,View v){
        comanda=c;
        view=v;
    }

    public int getIdComanda(){
        return comanda.getId();
    }

    public Client getCLient(){
        return comanda.getClient();
    }

    public void afiseazaCmenzi(){
        view.showComenzi();
    }

    public void adaugaComanda(Comanda c){
        view.adaugaComanda(c);
    }

    public void updateComanda(Comanda c){
        view.modificaComanda(c);
    }
}
