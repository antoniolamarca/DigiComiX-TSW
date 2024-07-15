package Controller.Prodotto;

import Model.Carrello.Cart;
import Model.Utente.UtenteBean;
import Model.Utente.UtenteDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/AggiungiACarrello")
public class AggiungiACarrello extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("servlet aggiunta a carrello avviata");
        UtenteBean utenteBean = new UtenteBean();
        UtenteDao utenteDao = new UtenteDao();
        Cart carrello=null;
        if (request.getSession().getAttribute("email") != null) {
            if(utenteDao)//fare un altro uf che controlla se il carrello esiste
            //se enon esiste lo creo lo aggiorno e ritorno
            //se esiste lo prendo lo aggiorno e o ritorno
        }
        else {
            response.sendRedirect("Pagine/Login.jsp");
        }
    }
}