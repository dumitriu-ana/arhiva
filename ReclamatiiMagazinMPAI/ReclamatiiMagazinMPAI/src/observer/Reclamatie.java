package observer;

import models.Comanda;
import state.InregistrataState;
import state.ReclamatieStare;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Reclamatie implements Subiect, Serializable {
    private static final long serialVersionUID = 1L;

    private int idReclamatie;
    private String numeClient;
    private Comanda comanda;
    private String descriere;
    private ReclamatieStare reclamatieStare;///interfata Stare


    private List<Observer> listaObserveri=new ArrayList<>();

    public Reclamatie(int idReclamatie, String numeClient, Comanda comanda, String descriere) {
        this.idReclamatie = idReclamatie;
        this.numeClient = numeClient;
        this.comanda = comanda;
        this.descriere = descriere;
        this.reclamatieStare = new InregistrataState();
    }

    public String getNumeClient() {
        return numeClient;
    }

    public void setNumeClient(String numeClient) {
        this.numeClient = numeClient;
    }

    public int getIdReclamatie() {
        return idReclamatie;
    }

    public void setIdReclamatie(int idReclamatie) {
        this.idReclamatie = idReclamatie;
    }

    public Comanda getComanda() {
        return comanda;
    }

    public void setComanda(Comanda comanda) {
        this.comanda = comanda;
    }

    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    public ReclamatieStare getReclamatieStare() {
        return reclamatieStare;
    }

    public void setReclamatieStare(ReclamatieStare reclamatieStare) {
        this.reclamatieStare = reclamatieStare;
        notifyAllObservers();
    }


    @Override
    public void addObserver(Observer observer) {
        if (listaObserveri.isEmpty()){
            listaObserveri.add(observer);
        }
    }

    @Override
    public void removeObserver(Observer observer) {
        listaObserveri.remove(observer);
    }

    @Override
    public void notifyAllObservers() {
        for (Observer observer:listaObserveri){
            observer.update(reclamatieStare.getStare());
        }
    }

    @Override
    public String toString() {
        return "Reclamatie{" +
                "idReclamatie=" + idReclamatie +
                ", numeClient='" + numeClient + '\'' +
                ", comanda=" + comanda +
                ", descriere='" + descriere + '\'' +
                ", reclamatieStare=" + reclamatieStare.getStare() +
                '}';
    }
}
