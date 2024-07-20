package Model.Carrello;

import Model.Prodotto.ArticoloDao;
import Model.Prodotto.ArticoloBean;

import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;

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

    //Funzione che serializza un oggetto in una stringa:
    public static String serializzaToString(Serializable object) throws Exception {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(object);
        oos.close();

        // Codifica l'array di byte in base64
        byte[] byteData = bos.toByteArray();
        return Base64.getEncoder().encodeToString(byteData);
    }

    //Funzione che deserializza una stringa in un oggetto
    public static Object deserializzaFromString(String stringaSerializzata) throws Exception {
        // Decodifica la stringa in base64 in un array di byte
        byte[] byteData = Base64.getDecoder().decode(stringaSerializzata);

        // Crea un flusso di input per leggere l'array di byte
        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(byteData));

        // Deserializza l'oggetto dal flusso di input
        Object objectDeserializzato = ois.readObject();

        // Chiudi il flusso di input
        ois.close();

        return objectDeserializzato;
    }

}


//ho parlato con antonio d'aurios e non conviene avere l'attributo carrello nell'entità account
//mi ha consigliato di usare solamente la sessione e di fare dei metodi di aggiunta del carrello direttamente
//nell'oggetto Cart
// aggiungere alla jsp il link alla servlet