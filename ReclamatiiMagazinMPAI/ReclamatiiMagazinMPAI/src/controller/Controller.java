package controller;

import models.Model;
import observer.Reclamatie;
import state.AnalizaState;
import state.SolutionataState;
import view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Controller {
    private Model model;
    private View view;

    private List<Reclamatie> reclamatieList=new ArrayList<>();

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
        this.reclamatieList=model.getReclamatieList();
    }

    public void loadReclamatii() {
        view.afiseazaReclamatii(reclamatieList);
    }

    public void changeState(int idReclamatie, String status) {
        for(Reclamatie reclamatie:reclamatieList){
            if(reclamatie.getIdReclamatie() == idReclamatie){
                if (status.equalsIgnoreCase("IN ANALIZA")){
                    reclamatie.addObserver(model.getClientByName(reclamatie.getNumeClient()));
                    reclamatie.setReclamatieStare(new AnalizaState());
                }
                else if (status.equalsIgnoreCase("SOLUTIONATA")){
                    reclamatie.addObserver(model.getClientByName(reclamatie.getNumeClient()));
                    reclamatie.setReclamatieStare(new SolutionataState());
                } else {
                    System.out.println("NU ATI INTRODUS CORECT!");
                }
            }
        }
        model.saveInFile();
    }

    public void getReclamatiiByNumeClient(String nume) {
        List<Reclamatie> filteredReclamatii=reclamatieList.stream()
                .filter(reclamatie ->
                        reclamatie.getNumeClient().equalsIgnoreCase(nume))
                .collect(Collectors.toList());
        view.afiseazaReclamatii(filteredReclamatii);
    }

    public void getReclamatiiByIdDESC() {
        List<Reclamatie> filteredReclamatii=reclamatieList.stream()
                .sorted((r1,r2)->
                        Integer.compare(r2.getIdReclamatie(),r1.getIdReclamatie()))
                .collect(Collectors.toList());
        view.afiseazaReclamatii(filteredReclamatii);
    }
}
