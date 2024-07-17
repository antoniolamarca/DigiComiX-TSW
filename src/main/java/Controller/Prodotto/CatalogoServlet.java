package Controller.Prodotto;

import Model.Prodotto.ArticoloBean;
import Model.Prodotto.ArticoloDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Model.Prodotto.ArticoloBean;


@WebServlet("/CatalogoServlet")
public class CatalogoServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        System.out.println("Catalogo in funzione");//flag
        String tipo = request.getParameter("tipo");
        ArticoloDao articolo=new ArticoloDao();
        try {
            if(tipo.equals("novita")) {
                request.getSession().setAttribute("CatalogoFiltrato",articolo.doGetByNovita());
            } else if (tipo.equals("sconti")) {
                request.getSession().setAttribute("CatalogoFiltrato",articolo.doGetBySconto());
            } else {
                request.getSession().setAttribute("CatalogoFiltrato",articolo.doGetByTipo(tipo));
            }
            response.sendRedirect("Pagine/Catalogo.jsp");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
