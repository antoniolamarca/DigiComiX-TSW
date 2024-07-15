package Model.Utente;





import Model.DriverManagerConnectionPool;
import Model.Prodotto.ArticoloBean;
import Model.Utente.UtenteBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;
public class UtenteDao {


    //Si occupa di salvare un utente nel db:
    public void doSave(UtenteBean utente) throws SQLException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        String insertSQL = "INSERT INTO ACCOUNT_UTENTE (Nome, Cognome, Email, Passkey, Tipo) VALUES (?,?,?,?,?) ";

        try {
            connection = DriverManagerConnectionPool.getConnection();
            System.out.println("Stabilita connessione, stiamo salvando");
            preparedStatement = connection.prepareStatement(insertSQL);
            preparedStatement.setString(1, utente.getNome());
            preparedStatement.setString(2, utente.getCognome());
            preparedStatement.setString(3, utente.getEmail());
            preparedStatement.setString(4, utente.getPassword());
            preparedStatement.setString(5, "utente");

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

    public boolean IsEmailPresent(String email) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String insertSQL = "SELECT * FROM ACCOUNT_UTENTE WHERE Email = ?";

        try {
            connection = DriverManagerConnectionPool.getConnection();
            System.out.println("Stabilita connessione");
            preparedStatement = connection.prepareStatement(insertSQL);
            preparedStatement.setString(1, email);
            resultSet = preparedStatement.executeQuery();
            return resultSet.next(); //check

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


    public UtenteBean GetUtente(String email) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String insertSQL = "SELECT * FROM ACCOUNT_UTENTE WHERE Email = ?";
        UtenteBean utentebean = null;
        try {
            connection = DriverManagerConnectionPool.getConnection();
            System.out.println("connessione stabilita");
            preparedStatement = connection.prepareStatement(insertSQL);
            preparedStatement.setString(1, email);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                utentebean = new UtenteBean();
                utentebean.setId(resultSet.getInt("id"));
                utentebean.setNome(resultSet.getString("Nome"));
                utentebean.setCognome(resultSet.getString("Cognome"));
                utentebean.setTipo(resultSet.getString("Tipo"));
                utentebean.setPassword(resultSet.getString("Passkey"));

                return utentebean;
            }

            return utentebean;

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
    /*public UtenteBean GetCarrello(String email) throws SQLException{ //funzione che prende il carrello
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String insertSQL = "SELECT * FROM ACCOUNT_UTENTE WHERE Email = ?";
        UtenteBean utentebean= null;
        try {
            connection = DriverManagerConnectionPool.getConnection();
            System.out.println("connessione stabilita");
            preparedStatement = connection.prepareStatement(insertSQL);
            preparedStatement.setString(1,email);
            resultSet = preparedStatement.executeQuery();
        }

        //funzione che imposta il nuovo carrello aggiornato
    }
*/
