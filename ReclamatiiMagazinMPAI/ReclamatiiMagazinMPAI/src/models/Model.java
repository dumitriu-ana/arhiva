package models;

import dataMapper.ClientMapper;
import dataMapper.ComandaMapper;
import dataMapper.ProduseMapper;
import dataMapper.ReclamatieMapper;
import observer.Client;
import observer.Reclamatie;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private List<Client> clientList=new ArrayList<>();
    private List<Comanda> comandaList=new ArrayList<>();
    private List<Produse> produseList=new ArrayList<>();
    private List<Reclamatie> reclamatieList= new ArrayList<>();

    public void getAllFromFile(){
        clientList= ClientMapper.getAllClienti();
        comandaList= ComandaMapper.getAllComenzi();
        produseList= ProduseMapper.getAllProduse();
        reclamatieList= ReclamatieMapper.getAllReclamatii();
    }

    public void saveInFile(){
        ClientMapper.saveClientiInFile(clientList);
        ComandaMapper.saveComenziInFile(comandaList);
        ProduseMapper.saveProduseInFile(produseList);
        ReclamatieMapper.saveReclamatiiInFile(reclamatieList);
    }

    public Client getClientByName(String name){
        for(Client client:clientList){
            if(client.getNumeClient().equalsIgnoreCase(name)){
                return client;
            }
        }
        throw new IllegalArgumentException("Nu exista acest Client");
    }

    public List<Client> getClientList() {
        return clientList;
    }

    public List<Comanda> getComandaList() {
        return comandaList;
    }

    public List<Produse> getProduseList() {
        return produseList;
    }

    public List<Reclamatie> getReclamatieList() {
        return reclamatieList;
    }
}
