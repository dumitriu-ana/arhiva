package dataMapper;

import models.Comanda;
import models.Produse;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProduseMapper {

    public static List<Produse> getAllProduse(){
        List<Produse> produse;
        try(ObjectInputStream ois=new ObjectInputStream(new FileInputStream("produse.dat"))) {
            produse= (List<Produse>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
        return produse;
    }

    public static void saveProduseInFile(List<Produse> produse){
        try(ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("produse.dat"))) {
            oos.writeObject(produse);
        }  catch (IOException e) {
            e.printStackTrace();
        }
    }
}
