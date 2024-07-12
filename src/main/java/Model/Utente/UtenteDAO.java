package Model.Utente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UtenteDAO {
    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;

    public UtenteDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }

    protected void connect() throws SQLException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            jdbcConnection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        }
    }

    protected void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }

    public boolean insertUtente(UtenteBean utente) throws SQLException {
        String sql = "INSERT INTO ACCOUNT_UTENTE (Nome, Cognome, Email, Passkey, Tipo) VALUES (?, ?, ?, ?, ?)";
        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, utente.getNome());
        statement.setString(2, utente.getCognome());
        statement.setString(3, utente.getEmail());
        statement.setString(4, utente.getPasskey());
        statement.setString(5, utente.getTipo());

        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;
    }

    public List<UtenteBean> listAllUtenti() throws SQLException {
        List<UtenteBean> listUtente = new ArrayList<>();

        String sql = "SELECT * FROM ACCOUNT_UTENTE";

        connect();

        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            int id = resultSet.getInt("Id");
            String nome = resultSet.getString("Nome");
            String cognome = resultSet.getString("Cognome");
            String email = resultSet.getString("Email");
            String passkey = resultSet.getString("Passkey");
            String tipo = resultSet.getString("Tipo");

            UtenteBean utente = new UtenteBean();
            utente.setId(id);
            utente.setNome(nome);
            utente.setCognome(cognome);
            utente.setEmail(email);
            utente.setPasskey(passkey);
            utente.setTipo(tipo);

            listUtente.add(utente);
        }

        resultSet.close();
        statement.close();

        disconnect();

        return listUtente;
    }

    public boolean deleteUtente(UtenteBean utente) throws SQLException {
        String sql = "DELETE FROM ACCOUNT_UTENTE where Id = ?";

        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, utente.getId());

        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowDeleted;
    }

    public boolean updateUtente(UtenteBean utente) throws SQLException {
        String sql = "UPDATE ACCOUNT_UTENTE SET Nome = ?, Cognome = ?, Email = ?, Passkey = ?, Tipo = ?";
        sql += " WHERE Id = ?";
        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, utente.getNome());
        statement.setString(2, utente.getCognome());
        statement.setString(3, utente.getEmail());
        statement.setString(4, utente.getPasskey());
        statement.setString(5, utente.getTipo());
        statement.setInt(6, utente.getId());

        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowUpdated;
    }

    public UtenteBean getUtente(int id) throws SQLException {
        UtenteBean utente = null;
        String sql = "SELECT * FROM ACCOUNT_UTENTE WHERE Id = ?";

        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, id);

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            String nome = resultSet.getString("Nome");
            String cognome = resultSet.getString("Cognome");
            String email = resultSet.getString("Email");
            String passkey = resultSet.getString("Passkey");
            String tipo = resultSet.getString("Tipo");

            utente = new UtenteBean();
            utente.setId(id);
            utente.setNome(nome);
            utente.setCognome(cognome);
            utente.setEmail(email);
            utente.setPasskey(passkey);
            utente.setTipo(tipo);
        }

        resultSet.close();
        statement.close();

        return utente;
    }
}
