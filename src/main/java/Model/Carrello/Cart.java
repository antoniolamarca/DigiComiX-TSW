package Model.Carrello;

import Model.Prodotto.ArticoloBean;

import java.io.Serializable;
import java.util.ArrayList;

public class Cart implements Serializable {
    ArrayList<ArticoloBean> Carrello;

    public ArrayList<ArticoloBean> getCarrello() {
        return Carrello;
    }

    public void setCarrello(ArrayList<ArticoloBean> carrello) {
        Carrello = carrello;
    }

    public Cart(ArrayList<ArticoloBean> carrello) {
        Carrello = new ArrayList<>();
    }
}

