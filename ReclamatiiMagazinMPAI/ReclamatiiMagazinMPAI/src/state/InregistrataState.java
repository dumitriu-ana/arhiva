package state;

import java.io.Serializable;

public class InregistrataState implements ReclamatieStare, Serializable {
    private static final long serialVersionUID = 1L;

    private String status = "INREGISTRATA";

    public InregistrataState() {
    }

//    @Override
//    public String handleRequest() {
//        System.out.println("Reclamatia este INREGISTRATA ");
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
