package model.observer;

import model.state.Comanda;

import java.io.Serializable;

public class Client implements Serializable, Observer {
    private static final long serialVersionUID = 1L;

    private String nume;
    private int varsta;

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public Client(String nume, int varsta){
        this.nume=nume;
        this.varsta=varsta;
    }

    @Override
    public void primesteNotificare(Comanda comanda) {
        System.out.println("comanda are starea: " + comanda.getStare().toString());
    }

    @Override
    public String toString() {
        return "Client{" +
                "nume='" + nume + '\'' +
                ", varsta=" + varsta +
                '}';
    }
}
