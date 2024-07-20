package Controller.Utente;

import Model.Ordine.OrdineBean;
import Model.Ordine.OrdineDao;
import Model.Prodotto.ArticoloBean;
import Model.Prodotto.ArticoloDao;
import Model.Utente.UtenteBean;
import Model.Utente.UtenteDao;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/PopolaAdmin")
public class PopolaAdmin extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //Prendiamo tutti gli articoli:
        ArticoloDao articoloDao = new ArticoloDao();
        ArrayList<ArticoloBean> listaArticoli = null;
        try {
            listaArticoli = articoloDao.doGetAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        req.getSession().setAttribute("listaArticoli", listaArticoli);


        //Prendiamo tutti gli utenti:
        UtenteDao utenteDao = new UtenteDao();
        ArrayList<UtenteBean> utenti = null;
        try {
             utenti= utenteDao.GetAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        req.getSession().setAttribute("listaUtenti", utenti );

        //Prendiamo tutti gli ordini:
        OrdineDao ordineDao = new OrdineDao();
        ArrayList<OrdineBean> ordini= null;

        try {
            ordini = ordineDao.doGetAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        req.getSession().setAttribute("listaOrdini", ordini);


        resp.sendRedirect("Pagine/Admin.jsp");


    }
}
