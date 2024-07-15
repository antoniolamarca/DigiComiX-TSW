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
        HttpSession session = request.getSession();
        Cart cart=null;
        synchronized (session){
           cart= (Cart) session.getAttribute("cart");
           if(cart==null){
               cart= new Cart();
               session.setAttribute("cart", cart);
           }
        }
        int id= Integer.parseInt(request.getParameter("id"));
        try {
            cart.addArticolo(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}