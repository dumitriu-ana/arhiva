package view;

import observer.Reclamatie;

import java.util.List;

public class ConcreteView implements View{
    @Override
    public void afiseazaReclamatii(List<Reclamatie> reclamatieList) {
        if(reclamatieList.isEmpty()){
            System.out.println("Nu exista nicio reclamtie");
        }else {
            System.out.println("Lista de reclamatii:");
            for(Reclamatie reclamatie:reclamatieList){
                System.out.println(reclamatie);
            }
        }
    }
}
