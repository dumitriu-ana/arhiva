package state;

import java.io.Serializable;

public class AnalizaState implements ReclamatieStare, Serializable {

    private static final long serialVersionUID = 1L;

    private String status = "IN ANALIZA";

//    @Override
//    public String handleRequest() {
//        System.out.println("Reclamatia este IN ANALIZA ");
//    }
//
//    @Override
//    public String toString() {
//        return status;
//    }

    @Override
    public String getStare() {
        return status;
    }
}
