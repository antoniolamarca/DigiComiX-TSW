package Controller.Prodotto;

import Model.Prodotto.ProdottoBean;
import Model.Prodotto.ProdottoDAO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet ("/AddProdotto")
public class ProdottoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ProdottoDAO prodottoDAO;

    public void init() {
        String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");

        prodottoDAO = new ProdottoDAO(jdbcURL, jdbcUsername, jdbcPassword);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/newProdotto":
                    showNewForm(request, response);
                    break;
                case "/insertProdotto":
                    insertProdotto(request, response);
                    break;
                case "/deleteProdotto":
                    deleteProdotto(request, response);
                    break;
                case "/editProdotto":
                    showEditForm(request, response);
                    break;
                case "/updateProdotto":
                    updateProdotto(request, response);
                    break;
                default:
                    listProdotto(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listProdotto(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<ProdottoBean> listProdotto = prodottoDAO.listAllProdotti();
        request.setAttribute("listProdotto", listProdotto);
        RequestDispatcher dispatcher = request.getRequestDispatcher("ProdottoList.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("ProdottoForm.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        ProdottoBean existingProdotto = prodottoDAO.getProdotto(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("ProdottoForm.jsp");
        request.setAttribute("prodotto", existingProdotto);
        dispatcher.forward(request, response);
    }

    private void insertProdotto(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String nome = request.getParameter("nome");
        String descrizione = request.getParameter("descrizione");
        double iva = Double.parseDouble(request.getParameter("iva"));
        double prezzo = Double.parseDouble(request.getParameter("prezzo"));
        String dataUscita = request.getParameter("dataUscita");
        int quantità = Integer.parseInt(request.getParameter("quantità"));
        String img = request.getParameter("img");
        String piattaforma = request.getParameter("piattaforma");
        String genere = request.getParameter("genere");
        String descDett = request.getParameter("descDett");

        ProdottoBean nuovoProdotto = new ProdottoBean();
        nuovoProdotto.setNome(nome);
        nuovoProdotto.setDescrizione(descrizione);
        nuovoProdotto.setIva(iva);
        nuovoProdotto.setPrezzo(prezzo);
        nuovoProdotto.setDataUscita(dataUscita);
        nuovoProdotto.setQuantità(quantità);
        nuovoProdotto.setImg(img);
        nuovoProdotto.setPiattaforma(piattaforma);
        nuovoProdotto.setGenere(genere);
        nuovoProdotto.setDescDett(descDett);

        prodottoDAO.insertProdotto(nuovoProdotto);
        response.sendRedirect("listProdotto");
    }

    private void updateProdotto(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nome = request.getParameter("nome");
        String descrizione = request.getParameter("descrizione");
        double iva = Double.parseDouble(request.getParameter("iva"));
        double prezzo = Double.parseDouble(request.getParameter("prezzo"));
        String dataUscita = request.getParameter("dataUscita");
        int quantità = Integer.parseInt(request.getParameter("quantità"));
        String img = request.getParameter("img");
        String piattaforma = request.getParameter("piattaforma");
        String genere = request.getParameter("genere");
        String descDett = request.getParameter("descDett");

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

        prodottoDAO.updateProdotto(prodotto);
        response.sendRedirect("listProdotto");
    }

    private void deleteProdotto(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        ProdottoBean prodotto = new ProdottoBean();
        prodotto.setId(id);

        prodottoDAO.deleteProdotto(prodotto);
        response.sendRedirect("listProdotto");
    }
}
