package Controller.Utente;

import Model.Utente.UtenteBean;
import Model.Utente.UtenteDao;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/registerUser")
public class Registrazione extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
    {
        System.out.println("Siamo nella servlet");
        UtenteBean utente= new UtenteBean();
        UtenteDao dao= new UtenteDao();

        utente.setNome(request.getParameter("nome"));
        utente.setCognome(request.getParameter("cognome"));
        utente.setEmail(request.getParameter("email"));
        utente.setPassword(request.getParameter("password"));

        try {
            dao.doSave(utente);
            response.sendRedirect("/Pagine/Login.jsp");
        } catch (SQLException | IOException e) {
            System.out.println("Siamo nella servlet, errore salvatagio");
            throw new RuntimeException(e);

        }


    }
}
