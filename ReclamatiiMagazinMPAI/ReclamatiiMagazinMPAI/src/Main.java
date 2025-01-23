import controller.Controller;
import dataMapper.ClientMapper;
import models.Comanda;
import models.Model;
import models.Produse;
import observer.Client;
import observer.Reclamatie;
import view.ConcreteView;
import view.View;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Model model=new Model();
        View view=new ConcreteView();

//
//        Client client=new Client(1,"George");
//        model.getClientList().add(client);
//        Client client1=new Client(2,"Marian");
//        model.getClientList().add(client1);
//
//        Produse produse=new Produse(1,"Gel");
//        model.getProduseList().add(produse);
//        Produse produse1=new Produse(2,"sampon");
//        model.getProduseList().add(produse1);
//
//        Comanda comanda=new Comanda(1,1,model.getProduseList());
//        model.getComandaList().add(comanda);
//        Comanda comanda2=new Comanda(2,1,model.getProduseList());
//        model.getComandaList().add(comanda2);
//
//        Reclamatie reclamatie=new Reclamatie(1,"George",comanda,"Nu e ok gelul");
//        model.getReclamatieList().add(reclamatie);
//        Reclamatie reclamatie2=new Reclamatie(2,"George",comanda2,"Nu e ok samponul");
//        model.getReclamatieList().add(reclamatie2);
//
//        model.saveInFile();

        model.getAllFromFile();
        Controller controller=new Controller(model,view);

        Scanner scanner=new Scanner(System.in);
        boolean running=true;

        while (running){
            System.out.println("\n1. View requests");
            System.out.println("2. Add request");
            System.out.println("3. Update request status");
            System.out.println("4. Filter requests by Name");
            System.out.println("5. Order requests by id");
            System.out.println("6. Exit");
            System.out.println("Choose an option: ");
            int optiune=scanner.nextInt();
            scanner.nextLine();
            switch (optiune){
                case 1:
                    controller.loadReclamatii();
                    break;
                case 2:
                    ///
                    break;
                case 3:
                    System.out.println("Alegeti id-ul reclamatiei:");
                    int idReclamatie=scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Alegeti statusul:");
                    String status=scanner.nextLine();
                    controller.changeState(idReclamatie,status);
                    break;
                case 4:
                    System.out.println("Alegeti numele dupa care vreti sa filtrati: ");
                    String nume=scanner.nextLine();
                    controller.getReclamatiiByNumeClient(nume);
                    break;
                case 5:
                    controller.getReclamatiiByIdDESC();
                    break;
                case 6:
                    running=false;
                    break;
                default:
                    System.out.println("Nu ati ales nicio optiune valida!");
            }
        }
    }
}