package Controller.Prodotto;

import Model.Carrello.Cart;
import Model.Prodotto.ArticoloDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/EliminaProdottoAdmin")

public class EliminaProdottoAdmin extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArticoloDao articoloDao = new ArticoloDao();
        Cart carrello = (Cart) req.getSession().getAttribute("cart");
        try {
            articoloDao.doDelete(Integer.parseInt(req.getParameter("eliminaidProdotto")));
            carrello.RemoveFromCart(Integer.parseInt(req.getParameter("eliminaidProdotto")));
            req.getSession().setAttribute("cart",carrello);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        resp.sendRedirect("Pagine/Admin.jsp");
    }
}
