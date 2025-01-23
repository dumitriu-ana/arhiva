package state;

import java.io.Serializable;

public class SolutionataState implements ReclamatieStare, Serializable {

    private static final long serialVersionUID=1L;

    private String stare="SOLUTIONATA";

//    @Override
//    public String handleRequest() {
//        System.out.println("Reclamatia este SOLUTIONATA ");
//    }
//
//    @Override
//    public String toString() {
//        return stare;
//    }

    @Override
    public String getStare() {
        return stare;
    }
}
