package Controller.Prodotto;

import Model.Prodotto.ArticoloBean;
import Model.Prodotto.ArticoloDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/AggiungiProdotto")

public class AggiungiProdotto  extends HttpServlet  {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ArticoloBean articolo = new ArticoloBean();
        ArticoloDao articoloDao = new ArticoloDao();

        articolo.setNome(req.getParameter("nome"));
        articolo.setDescrizione(req.getParameter("descrizione"));
        articolo.setPrezzo((int) Double.parseDouble(req.getParameter("prezzo")));
        articolo.setQuantita(Integer.parseInt(req.getParameter("quantita")));
        articolo.setNovita(req.getParameter("novita") != null);
        articolo.setSconti(req.getParameter("sconti") != null);
        articolo.setTipo(req.getParameter("tipo"));

        System.out.println("ciao sono qui");

        try {
            articoloDao.doSave(articolo);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        resp.sendRedirect("Pagine/Home.jsp");


    }

}
