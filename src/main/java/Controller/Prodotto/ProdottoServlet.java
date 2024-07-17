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

@WebServlet("/ProdottoServlet")
public class ProdottoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id= Integer.parseInt(req.getParameter("ID"));

        ArticoloBean articolo = new ArticoloBean();
        ArticoloDao articoloDao = new ArticoloDao();

        //Prendiamo l'articolo dal db:
        try {
            articolo= articoloDao.doGetById(id);
            req.getSession().setAttribute("ArticoloTrovato",articolo);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }




        req.getRequestDispatcher("Pagine/Prodotto.jsp").forward(req, resp);
    }
}
