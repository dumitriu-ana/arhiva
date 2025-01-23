package dataMapper;

import models.Comanda;
import observer.Reclamatie;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReclamatieMapper {

    public static List<Reclamatie> getAllReclamatii(){
        List<Reclamatie> reclamaties;
        try(ObjectInputStream ois=new ObjectInputStream(new FileInputStream("reclamatii.dat"))) {
            reclamaties= (List<Reclamatie>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
        return reclamaties;
    }

    public static void saveReclamatiiInFile(List<Reclamatie> reclamaties){
        try(ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("reclamatii.dat"))) {
            oos.writeObject(reclamaties);
        }  catch (IOException e) {
            e.printStackTrace();
        }
    }
}
