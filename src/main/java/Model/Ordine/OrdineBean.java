package Model.Ordine;

import java.time.LocalDate;
import java.util.Date;

public class OrdineBean {
    private int id;
    private int id_utente;
    private LocalDate data_ordine;
    private String indirizzo;
    private String prodotti_ordinati;

    public int getId() {
        return id;
    }

    public LocalDate getData_ordine() {
        return  data_ordine;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public String getProdotti_ordinati() {
        return prodotti_ordinati;
    }

    public void setProdotti_ordinati(String prodotti_ordinati) {
        this.prodotti_ordinati = prodotti_ordinati;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public void setData_ordine(LocalDate data_ordine) {
        this.data_ordine = data_ordine;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_utente() {
        return id_utente;
    }

    public void setId_utente(int id_utente) {
        this.id_utente = id_utente;
    }
}
