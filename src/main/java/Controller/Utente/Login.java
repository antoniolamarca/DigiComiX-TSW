package Controller.Utente;

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

@WebServlet("/LoginUser")
public class Login extends HttpServlet{
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("Siamo nella Servlet");
        UtenteBean utenteBean= new UtenteBean();
        UtenteDao utenteDao = new UtenteDao();
        String email=request.getParameter("email");
        String password=request.getParameter("password");
        try {
            if (utenteDao.IsEmailPresent(email)){
                utenteBean=utenteDao.GetUtente(email);

                if (utenteDao.checkUser(email,password)){
                    HttpSession session=request.getSession();
                    session.setAttribute("email", utenteBean.getEmail());
                    session.setAttribute("tipo", utenteBean.getTipo());
                    session.setAttribute("nome", utenteBean.getNome());
                    session.setAttribute("idUtente", utenteBean.getId());
                }
                response.sendRedirect("Pagine/Home.jsp");

            }else{
                response.sendRedirect("Pagine/Registrazione.jsp");
            }

        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
