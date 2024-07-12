package Model.Prodotto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdottoDAO {
    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;

    public ProdottoDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
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

    public boolean insertProdotto(ProdottoBean prodotto) throws SQLException {
        String sql = "INSERT INTO ARTICOLO (Nome, Descrizione, Iva, Prezzo, DataUscita, Quantità, Img, Piattaforma, Genere, DescDett) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, prodotto.getNome());
        statement.setString(2, prodotto.getDescrizione());
        statement.setDouble(3, prodotto.getIva());
        statement.setDouble(4, prodotto.getPrezzo());
        statement.setString(5, prodotto.getDataUscita());
        statement.setInt(6, prodotto.getQuantità());
        statement.setString(7, prodotto.getImg());
        statement.setString(8, prodotto.getPiattaforma());
        statement.setString(9, prodotto.getGenere());
        statement.setString(10, prodotto.getDescDett());

        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;
    }

    public List<ProdottoBean> listAllProdotti() throws SQLException {
        List<ProdottoBean> listProdotto = new ArrayList<>();

        String sql = "SELECT * FROM ARTICOLO";

        connect();

        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            int id = resultSet.getInt("Id");
            String nome = resultSet.getString("Nome");
            String descrizione = resultSet.getString("Descrizione");
            double iva = resultSet.getDouble("Iva");
            double prezzo = resultSet.getDouble("Prezzo");
            String dataUscita = resultSet.getString("DataUscita");
            int quantità = resultSet.getInt("Quantità");
            String img = resultSet.getString("Img");
            String piattaforma = resultSet.getString("Piattaforma");
            String genere = resultSet.getString("Genere");
            String descDett = resultSet.getString("DescDett");

            ProdottoBean prodotto = new ProdottoBean();
            prodotto.setId(id);
            prodotto.setNome(nome);
            prodotto.setDescrizione(descrizione);
            prodotto.setIva(iva);
            prodotto.setPrezzo(prezzo);
            prodotto.setDataUscita(dataUscita);
            prodotto.setQuantità(quantità);
            prodotto.setImg(img);
            prodotto.setPiattaforma(piattaforma);
            prodotto.setGenere(genere);
            prodotto.setDescDett(descDett);

            listProdotto.add(prodotto);
        }

        resultSet.close();
        statement.close();

        disconnect();

        return listProdotto;
    }

    public boolean deleteProdotto(ProdottoBean prodotto) throws SQLException {
        String sql = "DELETE FROM ARTICOLO where Id = ?";

        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, prodotto.getId());

        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowDeleted;
    }

    public boolean updateProdotto(ProdottoBean prodotto) throws SQLException {
        String sql = "UPDATE ARTICOLO SET Nome = ?, Descrizione = ?, Iva = ?, Prezzo = ?, DataUscita = ?, Quantità = ?, Img = ?, Piattaforma = ?, Genere = ?, DescDett = ? WHERE Id = ?";
        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, prodotto.getNome());
        statement.setString(2, prodotto.getDescrizione());
        statement.setDouble(3, prodotto.getIva());
        statement.setDouble(4, prodotto.getPrezzo());
        statement.setString(5, prodotto.getDataUscita());
        statement.setInt(6, prodotto.getQuantità());
        statement.setString(7, prodotto.getImg());
        statement.setString(8, prodotto.getPiattaforma());
        statement.setString(9, prodotto.getGenere());
        statement.setString(10, prodotto.getDescDett());
        statement.setInt(11, prodotto.getId());

        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowUpdated;
    }

    public ProdottoBean getProdotto(int id) throws SQLException {
        ProdottoBean prodotto = null;
        String sql = "SELECT * FROM ARTICOLO WHERE Id = ?";

        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, id);

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            String nome = resultSet.getString("Nome");
            String descrizione = resultSet.getString("Descrizione");
            double iva = resultSet.getDouble("Iva");
            double prezzo = resultSet.getDouble("Prezzo");
            String dataUscita = resultSet.getString("DataUscita");
            int quantità = resultSet.getInt("Quantità");
            String img = resultSet.getString("Img");
            String piattaforma = resultSet.getString("Piattaforma");
            String genere = resultSet.getString("Genere");
            String descDett = resultSet.getString("DescDett");

            prodotto = new ProdottoBean();
            prodotto.setId(id);
            prodotto.setNome(nome);
            prodotto.setDescrizione(descrizione);
            prodotto.setIva(iva);
            prodotto.setPrezzo(prezzo);
            prodotto.setDataUscita(dataUscita);
            prodotto.setQuantità(quantità);
            prodotto.setImg(img);
            prodotto.setPiattaforma(piattaforma);
            prodotto.setGenere(genere);
            prodotto.setDescDett(descDett);
        }

        resultSet.close();
        statement.close();

        return prodotto;
    }
}
