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

@WebServlet("/EliminaProdotto")
public class EliminaProdotto extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    ArticoloDao articoloDao = new ArticoloDao();
        try {
            articoloDao.doDelete(Integer.parseInt(req.getParameter("eliminaidProdotto")));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        resp.sendRedirect("Pagine/Home.jsp");


    }
}
