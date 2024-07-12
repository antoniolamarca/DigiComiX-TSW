package Controller.Utente;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/ACCOUNT_UTENTE")
public class UtenteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UtenteDAO utenteDAO;

    public void init() {
        String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");

        utenteDAO = new UtenteDAO(jdbcURL, jdbcUsername, jdbcPassword);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    insertUtente(request, response);
                    break;
                case "/delete":
                    deleteUtente(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateUtente(request, response);
                    break;
                default:
                    listUtente(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listUtente(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<UtenteBean> listUtente = utenteDAO.listAllUtenti();
        request.setAttribute("listUtente", listUtente);
        RequestDispatcher dispatcher = request.getRequestDispatcher("UtenteList.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("UtenteForm.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        UtenteBean existingUtente = utenteDAO.getUtente(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("UtenteForm.jsp");
        request.setAttribute("utente", existingUtente);
        dispatcher.forward(request, response);
    }

}