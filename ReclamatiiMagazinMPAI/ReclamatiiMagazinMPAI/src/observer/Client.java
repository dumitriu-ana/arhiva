package observer;

import java.io.Serializable;

public class Client implements Serializable, Observer {
    private int idClient;
    private String numeClient;

    private static final long serialVersionUID = 1L;

    public Client(int idClient, String numeClient) {
        this.idClient = idClient;
        this.numeClient = numeClient;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getNumeClient() {
        return numeClient;
    }

    public void setNumeClient(String numeClient) {
        this.numeClient = numeClient;
    }

    @Override
    public String toString() {
        return "Client{" +
                "idClient='" + idClient + '\'' +
                ", numeClient='" + numeClient + '\'' +
                '}';
    }

    @Override
    public void update(String mesaj) {
        System.out.println("NOTIFICARE: Va informam ca starea reclamatiei este: " +mesaj);
    }


}
