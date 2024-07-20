package Model.Utente;





import Model.DriverManagerConnectionPool;
import Model.Prodotto.ArticoloBean;
import Model.Utente.UtenteBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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


    public ArrayList<UtenteBean> GetAll() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<UtenteBean> utenti = new ArrayList<>();

        String insertSQL = "SELECT * FROM ACCOUNT_UTENTE ";
        UtenteBean utentebean = null;

        try {
            connection = DriverManagerConnectionPool.getConnection();
            System.out.println("connessione stabilita");
            preparedStatement = connection.prepareStatement(insertSQL);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                utentebean = new UtenteBean();
                utentebean.setEmail(resultSet.getString("Email"));
                utentebean.setId(resultSet.getInt("id"));
                utentebean.setNome(resultSet.getString("Nome"));
                utentebean.setCognome(resultSet.getString("Cognome"));
                utentebean.setTipo(resultSet.getString("Tipo"));
                utentebean.setPassword(resultSet.getString("Passkey"));

                utenti.add(utentebean);
            }

            return utenti;

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

    //verifica se username e password corrispondono
    //True= Corrispondono (utente Registrato)
    //False= non corrispondono (utente non reggistrato, oppure combinazione email e pass sbaglaita)
    public boolean checkUser(String email, String password) throws SQLException {
        UtenteDao utenteDAO = new UtenteDao();
        UtenteBean utenteBean = new UtenteBean();
        Connection connection = null;
        PreparedStatement ps = null;

        try {

            connection = DriverManagerConnectionPool.getConnection();
            System.out.println("connessione stabilita");


            ps = connection.prepareStatement("SELECT * FROM  ACCOUNT_UTENTE WHERE Email=? AND Passkey=SHA1(?)");
            ps.setString(1, email);
            ps.setString(2, password);

            // Debugging: Log the query
            System.out.println("Executing query: SELECT * FROM utenti WHERE Email='" + email + "'");

            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) { // Check if there's a result
                //Se esistono dei risultati, allora l utente esiste:
                return true;
            } else {
                // Debugging: Log when no result is found
                System.out.println("No user found with email: " + email);
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (ps != null)
                    ps.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                DriverManagerConnectionPool.releaseConnection(connection);
            }
        }

    }
}

   /* public UtenteBean GetCarrello(String email) throws SQLException{ //funzione che prende il carrello
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
