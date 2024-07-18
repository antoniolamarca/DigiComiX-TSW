package Model.Prodotto;


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

public class ArticoloDao {


    public void doSave(ArticoloBean articolo) throws SQLException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        String insertSQL = "INSERT INTO ARTICOLO (Nome, Prezzo, Descrizione, Tipo, Quantita, novita, sconti) VALUES (?,?,?,?,?,?,?) ";

        try {
            connection = DriverManagerConnectionPool.getConnection();
            System.out.println("Stabilita connessione, stiamo salvando");
            preparedStatement = connection.prepareStatement(insertSQL);
            preparedStatement.setString(1, articolo.getNome());
            preparedStatement.setInt(2, articolo.getPrezzo());
            preparedStatement.setString(3, articolo.getDescrizione());
            preparedStatement.setString(4, articolo.getTipo());
            preparedStatement.setInt(5, articolo.getQuantita());
            preparedStatement.setBoolean(6, articolo.isNovita());
            preparedStatement.setBoolean(7, articolo.isSconti());

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

            //Prendiamo i risultati dalla query
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                ArticoloBean articolo = new ArticoloBean();
                articolo.setId(resultSet.getInt("id"));
                articolo.setNome(resultSet.getString("Nome"));
                articolo.setPrezzo(resultSet.getInt("Prezzo"));
                articolo.setDescrizione(resultSet.getString("Descrizione"));
                articolo.setTipo(resultSet.getString("Tipo"));
                articolo.setQuantita(resultSet.getInt("Quantita"));
                articolo.setNovita(resultSet.getBoolean("novita"));
                articolo.setSconti(resultSet.getBoolean("Sconti"));

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

    public ArrayList<ArticoloBean> doGetByTipo(String tipo) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        String insertSQL = "SELECT * FROM ARTICOLO WHERE tipo=?";
        ResultSet resultSet = null;
        ArrayList<ArticoloBean> listaArticoli = new ArrayList<>();

        try {
            connection = DriverManagerConnectionPool.getConnection();
            System.out.println("Stabilita connessione, stiamo salvando");
            preparedStatement = connection.prepareStatement(insertSQL);
            preparedStatement.setString(1, tipo);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                ArticoloBean articolo = new ArticoloBean();
                articolo.setId(resultSet.getInt("id"));
                articolo.setNome(resultSet.getString("Nome"));
                articolo.setPrezzo(resultSet.getInt("Prezzo"));
                articolo.setDescrizione(resultSet.getString("Descrizione"));
                articolo.setTipo(resultSet.getString("Tipo"));
                articolo.setQuantita(resultSet.getInt("Quantita"));
                articolo.setNovita(resultSet.getBoolean("novita"));
                articolo.setSconti(resultSet.getBoolean("Sconti"));

                listaArticoli.add(articolo);
            }
            return listaArticoli;
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

    public ArrayList<ArticoloBean> doGetByNovita() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        String insertSQL = "SELECT * FROM ARTICOLO WHERE novita = 1";
        ResultSet resultSet = null;
        ArrayList<ArticoloBean> listaArticoli = new ArrayList<>();

        try {
            connection = DriverManagerConnectionPool.getConnection();
            System.out.println("Stabilita connessione, stiamo salvando");
            preparedStatement = connection.prepareStatement(insertSQL);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                ArticoloBean articolo = new ArticoloBean();
                articolo.setId(resultSet.getInt("id"));
                articolo.setNome(resultSet.getString("Nome"));
                articolo.setPrezzo(resultSet.getInt("Prezzo"));
                articolo.setDescrizione(resultSet.getString("Descrizione"));
                articolo.setTipo(resultSet.getString("Tipo"));
                articolo.setQuantita(resultSet.getInt("Quantita"));
                articolo.setNovita(resultSet.getBoolean("novita"));
                articolo.setSconti(resultSet.getBoolean("Sconti"));

                listaArticoli.add(articolo);
            }
            return listaArticoli;
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

    public ArrayList<ArticoloBean> doGetBySconto() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        String insertSQL = "SELECT * FROM ARTICOLO WHERE sconto = 1";
        ResultSet resultSet = null;
        ArrayList<ArticoloBean> listaArticoli = new ArrayList<>();

        try {
            connection = DriverManagerConnectionPool.getConnection();
            System.out.println("Stabilita connessione, stiamo salvando");
            preparedStatement = connection.prepareStatement(insertSQL);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                ArticoloBean articolo = new ArticoloBean();
                articolo.setId(resultSet.getInt("id"));
                articolo.setNome(resultSet.getString("Nome"));
                articolo.setPrezzo(resultSet.getInt("Prezzo"));
                articolo.setDescrizione(resultSet.getString("Descrizione"));
                articolo.setTipo(resultSet.getString("Tipo"));
                articolo.setQuantita(resultSet.getInt("Quantita"));
                articolo.setNovita(resultSet.getBoolean("novita"));
                articolo.setSconti(resultSet.getBoolean("Sconti"));

                listaArticoli.add(articolo);
            }
            return listaArticoli;
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

    public ArrayList<ArticoloBean> doGetAll() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        String insertSQL = "SELECT * FROM ARTICOLO";
        ResultSet resultSet = null;
        ArrayList<ArticoloBean> listaArticoli = new ArrayList<>();

        try {
            connection = DriverManagerConnectionPool.getConnection();
            System.out.println("Stabilita connessione, stiamo salvando");
            preparedStatement = connection.prepareStatement(insertSQL);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                ArticoloBean articolo = new ArticoloBean();
                articolo.setId(resultSet.getInt("id"));
                articolo.setNome(resultSet.getString("Nome"));
                articolo.setPrezzo(resultSet.getInt("Prezzo"));
                articolo.setDescrizione(resultSet.getString("Descrizione"));
                articolo.setTipo(resultSet.getString("Tipo"));
                articolo.setQuantita(resultSet.getInt("Quantita"));
                articolo.setNovita(resultSet.getBoolean("novita"));
                articolo.setSconti(resultSet.getBoolean("Sconti"));

                listaArticoli.add(articolo);
            }
            System.out.println(listaArticoli);
            return listaArticoli;
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




