package Model.Carrello;

import Model.Prodotto.ArticoloDao;
import Model.Prodotto.ArticoloBean;

import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Iterator;

public class Cart implements Serializable {
    private static final long serialVersionUID = 6664768527921825680L;
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


    public void RemoveFromCart(int id) throws SQLException {
        ArticoloDao articoloDao = new ArticoloDao();
        Iterator<ArticoloBean> iterator = this.carrello.iterator();

        while (iterator.hasNext()) {
            ArticoloBean o = iterator.next();
            if (o.getId() == id) {
                iterator.remove(); // Rimuove l'elemento corrente
                break; // Esce dal ciclo se si vuole rimuovere solo un elemento
            }
        }
    }

    public String serializeToString() throws IOException {
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
             ObjectOutputStream oos = new ObjectOutputStream(baos)) {
            oos.writeObject(this);
            return Base64.getEncoder().encodeToString(baos.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }

    //Deserializziamo la Stringa in un oggetto
    public static Object deserializeFromString(String string) throws IOException, ClassNotFoundException {
        byte[] data = Base64.getDecoder().decode(string);
        try (ByteArrayInputStream bais = new ByteArrayInputStream(data);
             ObjectInputStream ois = new ObjectInputStream(bais)) {
            return ois.readObject();
        }
    }

}


//ho parlato con antonio d'aurios e non conviene avere l'attributo carrello nell'entità account
//mi ha consigliato di usare solamente la sessione e di fare dei metodi di aggiunta del carrello direttamente
//nell'oggetto Cart
// aggiungere alla jsp il link alla servlet