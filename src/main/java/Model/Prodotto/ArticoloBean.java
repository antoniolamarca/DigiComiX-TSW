package Model.Prodotto;

import java.io.*;
import java.util.Base64;

public class ArticoloBean implements Serializable {
    private int id;
    private String nome;
    private String tipo;
    private int prezzo;
    private String descrizione;
    private int quantita;
    private boolean novita;
    private boolean sconti;

    public String getImages(){
        return id+".jpg";
    }
    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setPrezzo(int prezzo) {
        this.prezzo = prezzo;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    public int getQuantita() {
        return quantita;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public int getPrezzo() {
        return prezzo;
    }

    public String getTipo() {
        return tipo;
    }

    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }

    public boolean isNovita() {
        return novita;
    }

    public boolean isSconti() {
        return sconti;
    }

    public void setNovita(boolean novita) {
        this.novita = novita;
    }

    public void setSconti(boolean sconti) {
        this.sconti = sconti;
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
