package model.state;

public class Inregistrata implements Stare{
    @Override
    public void schimbaStarea(Comanda comanda) {
        if(!(comanda.getStare() instanceof  Inregistrata))
            comanda.setStare(this);
    }

    @Override
    public String toString() {
        return "inregistrata";
    }
}
