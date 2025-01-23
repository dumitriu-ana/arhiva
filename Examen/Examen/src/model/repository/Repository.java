package model.repository;

import model.state.Comanda;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Repository implements IRepository<Comanda> {
    List<Comanda> comenzi=new ArrayList<>();

    @Override
    public List<Comanda> getAll() {
        try {
            File file = new File("date.dat");
            if (!file.exists()) {
                file.createNewFile();
            }

            ObjectInputStream ois=new ObjectInputStream(new FileInputStream("date.dat"));
            try {
                comenzi = (List<Comanda>) ois.readObject();
                ois.close();
                if(comenzi == null || comenzi.size()==0){
                    return null;
                }
                return comenzi;
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    @Override
    public Comanda get(int id) {
        comenzi=this.getAll();
        if(comenzi!=null || comenzi.size()>0){
            Comanda c= comenzi.stream().filter(com->com.getId()==id).collect(Collectors.toList()).get(0);
            return c;
        }
        return null;
    }

    @Override
    public void update(Comanda comanda) {
        comenzi=this.getAll();
        if(comenzi!=null || comenzi.size()>0){
            for(int i=0; i<comenzi.size();i++){
                if(comenzi.get(i).getId() == comanda.getId()){
                    comenzi.set(i,comanda);
                    try {
                        ObjectOutputStream ois= new ObjectOutputStream(new FileOutputStream("date.dat"));
                        ois.writeObject(comenzi);
                        ois.close();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

    @Override
    public void delete(Comanda comanda) {
        comenzi=this.getAll();
        if(comenzi!=null || comenzi.size()>0){
            boolean contine = comenzi.contains(comanda);
            if(contine)
                comenzi.remove(comanda);
            try {
                ObjectOutputStream ois= new ObjectOutputStream(new FileOutputStream("date.dat"));
                ois.writeObject(comenzi);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }

    @Override
    public void add(Comanda comanda) {
        comenzi=this.getAll();
        if(comenzi==null || comenzi.size()==0){
            comenzi.add(comanda);
            try {
                ObjectOutputStream ois= new ObjectOutputStream(new FileOutputStream("date.dat"));
                ois.writeObject(comenzi);
                ois.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        else if(comenzi.stream().filter(com->com.getId()==comanda.getId()).collect(Collectors.toList()).size()==0 ){
            comenzi.add(comanda);
            try {
                ObjectOutputStream ois= new ObjectOutputStream(new FileOutputStream("date.dat"));
                ois.writeObject(comenzi);
                ois.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
