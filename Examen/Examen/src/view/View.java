package view;

import model.repository.Repository;
import model.state.Comanda;

import java.util.List;

public class View {
   public void showComenzi(){
        Repository repo= new Repository();
        List<Comanda> listaComenzi= repo.getAll();
        for(Comanda c :listaComenzi ){
            System.out.println(c.toString());
        }
    }

    public void adaugaComanda(Comanda c){
        Repository repo= new Repository();
        repo.add(c);
        System.out.println("A fost adaugata comanda: " + c.getId());
    }

    public void modificaComanda(Comanda c){
        Repository repo= new Repository();
        repo.update(c);
        System.out.println("A fost modificata comanda: " + c.getId());
    }

    public void stergeComanda(Comanda c){
        Repository repo= new Repository();
        repo.delete(c);
        System.out.println("A fost stearsa comanda: " + c.getId());
    }

    public void selecteazaComanda(Comanda c){
        Repository repo= new Repository();
        repo.get(c.getId());
        System.out.println("A fost selectata comanda: " + c.getId());
    }


}
