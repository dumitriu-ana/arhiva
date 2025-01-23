package models;

import java.io.Serializable;

public class Produse implements Serializable {
    private int idProdus;
    private String nume;

    private static final long serialVersionUID = 1L;

    public Produse(int idProdus, String nume) {
        this.idProdus = idProdus;
        this.nume = nume;
    }

    public int getIdProdus() {
        return idProdus;
    }

    public void setIdProdus(int idProdus) {
        this.idProdus = idProdus;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    @Override
    public String toString() {
        return "Produse{" +
                "idProdus=" + idProdus +
                ", nume='" + nume + '\'' +
                '}';
    }
}
