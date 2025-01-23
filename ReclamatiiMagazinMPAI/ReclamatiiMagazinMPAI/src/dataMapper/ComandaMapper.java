package dataMapper;

import models.Comanda;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ComandaMapper {

    public static List<Comanda> getAllComenzi(){
        List<Comanda> comenzi;
        try(ObjectInputStream ois=new ObjectInputStream(new FileInputStream("comenzi.dat"))) {
            comenzi= (List<Comanda>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
           return new ArrayList<>();
        }
        return comenzi;
    }

    public static void saveComenziInFile(List<Comanda> comandas){
        try(ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("comenzi.dat"))) {
            oos.writeObject(comandas);
        }  catch (IOException e) {
            e.printStackTrace();
        }
    }
}
