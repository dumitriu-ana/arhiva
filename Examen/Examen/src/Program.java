import controller.Controller;
import model.observer.Client;
import model.observer.Notificare;
import model.state.Comanda;
import model.state.Inregistrata;
import view.View;

public class Program {
    public static void main(String[] args) {
        Client cl1= new Client("ionel",25);
        Client cl2= new Client("mihai",25);
        Notificare notif= new Notificare();
        Comanda c1=new Comanda(1,notif);
        c1.setClient(cl1);
        Comanda c2= new Comanda(2,notif);
        c2.setClient(cl2);


        notif.adaugaObserver(cl1);
        notif.adaugaObserver(cl2);

        View view= new View();
        Controller controller = new Controller(c1,view);

        controller.adaugaComanda(c1);

        controller.adaugaComanda(c2);
        controller.afiseazaCmenzi();

        c1.seteazaLivrata();
        c2.seteazaPregatita();
        controller.updateComanda(c1);

        controller.afiseazaCmenzi();

    }
}
