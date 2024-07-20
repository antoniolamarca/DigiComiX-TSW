package Model.Ordine;

import Model.Carrello.Cart;
import Model.DriverManagerConnectionPool;
import Model.Ordine.OrdineDao;
import Model.Prodotto.ArticoloBean;
import Model.Utente.UtenteBean;


import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

public class OrdineDao {
    public void doSave(OrdineBean ordine) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        String insertSQL = "INSERT INTO ORDINE(id_utente, Data_ordine, indirizzo, prodotti_ordinati) VALUES(?,?,?,?)";

        try {
            connection = DriverManagerConnectionPool.getConnection();
            System.out.println("Stabilita connessione, stiamo salvando");
            preparedStatement = connection.prepareStatement(insertSQL);
            preparedStatement.setInt(1, ordine.getId_utente());
            preparedStatement.setDate(2, Date.valueOf(ordine.getData_ordine()));
            preparedStatement.setString(3, ordine.getIndirizzo());
            preparedStatement.setString(4, ordine.getProdotti_ordinati().serializeToString());

            preparedStatement.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (preparedStatement != null)
                    preparedStatement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                DriverManagerConnectionPool.releaseConnection(connection);
            }
        }

    }

    public ArrayList<OrdineBean> doGetAll() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ArrayList<OrdineBean> ordini = new ArrayList<>();
        String insertSQL = "SELECT * FROM Ordine";

        try {
            connection = DriverManagerConnectionPool.getConnection();
            System.out.println("Stabilita connessione, stiamo salvando");
            preparedStatement = connection.prepareStatement(insertSQL);

            ResultSet rs= preparedStatement.executeQuery();
            while (rs.next()){
                OrdineBean ordineBean = new OrdineBean();

                ordineBean.setId(rs.getInt("Id"));
                ordineBean.setId_utente(rs.getInt("Id_utente"));
                ordineBean.setData_ordine(rs.getDate("Data_ordine").toLocalDate());
                ordineBean.setIndirizzo(rs.getString("indirizzo"));
                ordineBean.setProdotti_ordinati( (Cart) Cart.deserializeFromString(rs.getString("Prodotti_ordinati")));

                ordini.add(ordineBean);
            }
            return ordini;

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (preparedStatement != null)
                    preparedStatement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                DriverManagerConnectionPool.releaseConnection(connection);
            }
        }

    }
}
