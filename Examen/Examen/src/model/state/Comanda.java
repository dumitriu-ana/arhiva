package model.state;

import model.observer.Client;
import model.observer.Notificare;

import java.io.Serializable;

public class Comanda implements Serializable {

    private static final long serialVersionUID = 1L;
    private int id;
    private Stare stare;
    private Notificare notificare;
    Client client;

    public Comanda(int id, Notificare notificare){
        stare= new Inregistrata();
        this.notificare=notificare;
        this.id=id;
    }

    public int getId() {
        return id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStare(Stare stare) {
        this.stare = stare;
        System.out.println("Abonat notificat prin:");
        notificare.notificaAbonati(this);
    }

    public Stare getStare() {
        return stare;
    }

    public void seteazaLivrata(){
        Livrata stare= new Livrata();
        stare.schimbaStarea(this);
    }

    public void seteazaIngegistrata(){
        Inregistrata stare= new Inregistrata();
        stare.schimbaStarea(this);
    }

    public void seteazaPregatita(){
        Pregatita stare= new Pregatita();
        stare.schimbaStarea(this);
    }


    @Override
    public String toString() {
        return "Comanda [idComanda=" + getId() + ",client+ "+ getClient();
    }

}
