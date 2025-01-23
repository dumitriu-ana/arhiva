package dataMapper;

import models.Comanda;
import observer.Client;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ClientMapper {

    public static List<Client> getAllClienti(){
        List<Client> clients;
        try(ObjectInputStream ois=new ObjectInputStream(new FileInputStream("clienti.dat"))) {
            clients= (List<Client>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
        return clients;
    }

    public static void saveClientiInFile(List<Client> clients){
        try(ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("clienti.dat"))) {
            oos.writeObject(clients);
        }  catch (IOException e) {
            e.printStackTrace();
        }
    }
}
