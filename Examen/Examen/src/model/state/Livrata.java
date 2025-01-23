package model.state;

public class Livrata implements Stare{
    @Override
    public void schimbaStarea(Comanda comanda) {
        if(!(comanda.getStare() instanceof Livrata))
            comanda.setStare(this);
    }

    @Override
    public String toString() {
        return "livrata";
    }
}
