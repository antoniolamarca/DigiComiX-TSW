package Model.Carrello;

import Model.ArticoloDao;
import Model.Prodotto.ArticoloBean;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;

public class Cart implements Serializable {
   private ArrayList<ArticoloBean> carrello;

    public ArrayList<ArticoloBean> getCarrello() {
        return carrello;
    }

    public void setCarrello(ArrayList<ArticoloBean> carrello) {
        this.carrello = carrello;
    }

    public Cart() {
        carrello = new ArrayList<>();
    }


    public synchronized void addArticolo(int id) throws SQLException {
        ArticoloDao elemento = new ArticoloDao();
        ArticoloBean articoloBean= elemento.doGetById(id);
        carrello.add(articoloBean);
    }

}


//ho parlato con antonio d'aurios e non conviene avere l'attributo carrello nell'entità account
//mi ha consigliato di usare solamente la sessione e di fare dei metodi di aggiunta del carrello direttamente
//nell'oggetto Cart
// aggiungere alla jsp il link alla servlet