package Model.Ordine;

import Model.DriverManagerConnectionPool;
import Model.Ordine.OrdineDao;
import Model.Prodotto.ArticoloBean;
import Model.Utente.UtenteBean;

import java.sql.*;
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
            preparedStatement.setString(4, ordine.getProdotti_ordinati());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
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
