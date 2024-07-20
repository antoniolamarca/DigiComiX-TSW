package Controller.Utente;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/accessAdmin")
public class AdminPage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getSession().getAttribute("tipo").equals("admin")){
            resp.sendRedirect("Pagine/Admin.jsp");
        }else{
            resp.sendRedirect("Pagine/Home.jsp");
        }
    }
}
