package Model.Ordine;

import Model.DriverManagerConnectionPool;
import Model.Ordine.OrdineDao;
import Model.Prodotto.ArticoloBean;
import Model.Utente.UtenteBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;
import java.sql.Date;

public class OrdineDao {
    public void doSave(OrdineBean ordine) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        String insertSQL = "INSERT INTO ORDINE(id, Data_ordine, indirizzo, prodotti-ordinati) VALUES(?,?,?,?)";

        try {
            connection = DriverManagerConnectionPool.getConnection();
            System.out.println("Stabilita connessione, stiamo salvando");
            preparedStatement = connection.prepareStatement(insertSQL);
            preparedStatement.setInt(1, ordine.getId());
            preparedStatement.setDate(2, ordine.getData_ordine());
            preparedStatement.setString(3, ordine.getIndirizzo());
            preparedStatement.setString(4, ordine.getProdotti_ordinati());
            preparedStatement.setString(5, "ordine");

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
