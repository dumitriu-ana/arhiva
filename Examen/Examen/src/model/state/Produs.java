package model.state;

import java.io.Serializable;

public class Produs implements Serializable {
    private static final long serialVersionUID = 1L;

    private int pret;
    private String denumire;

    public Produs(int pret, String denumire) {
        this.pret = pret;
        this.denumire= denumire;
    }


}
