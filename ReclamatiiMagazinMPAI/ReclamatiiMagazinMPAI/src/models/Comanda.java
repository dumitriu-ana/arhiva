package models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Comanda implements Serializable {
    private int idComanda;
    private int idClient;
    private List<Produse> produse=new ArrayList<>();

    private static final long serialVersionUID = 1L;

    public Comanda(int idComanda, int idClient, List<Produse> produse) {
        this.idComanda = idComanda;
        this.idClient = idClient;
        this.produse = produse;
    }

    public int getIdComanda() {
        return idComanda;
    }

    public void setIdComanda(int idComanda) {
        this.idComanda = idComanda;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public List<Produse> getProduse() {
        return produse;
    }

    public void setProduse(List<Produse> produse) {
        this.produse = produse;
    }

    @Override
    public String toString() {
        return "Comanda{" +
                "idComanda=" + idComanda +
                ", idClient=" + idClient +
                ", produse=" + produse +
                '}';
    }

}
