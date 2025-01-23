package model.state;

public class Pregatita implements Stare{
    @Override
    public void schimbaStarea(Comanda comanda) {
        if(!(comanda.getStare() instanceof Pregatita))
            comanda.setStare(this);
    }
    @Override
    public String toString() {
        return "pregatita";
    }
}
