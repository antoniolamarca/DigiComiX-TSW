package Model.Prodotto;


import Model.DriverManagerConnectionPool;
import Model.Prodotto.ArticoloBean;
import Model.Utente.UtenteBean;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;

public class ArticoloDao {


    public void doSave(ArticoloBean articolo) throws SQLException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        String insertSQL = "INSERT INTO ARTICOLO (Nome, Prezzo, Descrizione, Tipo, Quantità) VALUES (?,?,?,?,?) ";

        try {
            connection = DriverManagerConnectionPool.getConnection();
            System.out.println("Stabilita connessione, stiamo salvando");
            preparedStatement = connection.prepareStatement(insertSQL);
            preparedStatement.setString(1, articolo.getNome());
            preparedStatement.setInt(2, articolo.getPrezzo());
            preparedStatement.setString(3, articolo.getDescrizione());
            preparedStatement.setString(4, articolo.getTipo());
            preparedStatement.setInt(5, articolo.getQuantita());

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


    public ArticoloBean doGetById(int id) throws SQLException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        String insertSQL = "SELECT * FROM ARTICOLO WHERE id=?";
        ResultSet resultSet = null;

        try {
            connection = DriverManagerConnectionPool.getConnection();
            System.out.println("Stabilita connessione, stiamo salvando");
            preparedStatement = connection.prepareStatement(insertSQL);
            preparedStatement.setInt(1, id);

            //Prendiamo i risultati dalla querry
            resultSet=preparedStatement.executeQuery();

            while(resultSet.next()) {
                ArticoloBean articolo = new ArticoloBean();
                articolo.setId(resultSet.getInt("id"));
                articolo.setNome(resultSet.getString("Nome"));
                articolo.setPrezzo(resultSet.getInt("Prezzo"));
                articolo.setDescrizione(resultSet.getString("Descrizione"));
                articolo.setTipo(resultSet.getString("Tipo"));
                articolo.setQuantita(resultSet.getInt("Quantità"));

                return articolo;
            }

            return null;


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
