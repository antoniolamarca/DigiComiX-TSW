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

@WebServlet("/ModificaProdotto")
public class ModificaProdotto extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        ArticoloBean articolo = new ArticoloBean();
        ArticoloDao articoloDao = new ArticoloDao();

        System.out.println("servlet modifica prodotto avviata");
        System.out.println(request.getParameter("idProdottoModifica"));
        articolo.setId(Integer.parseInt(request.getParameter("idProdottoModifica")));
        articolo.setNome(request.getParameter("nomeModifica"));
        articolo.setDescrizione(request.getParameter("descrizioneModifica"));
        articolo.setPrezzo((int) Double.parseDouble(request.getParameter("prezzoModifica")));
        articolo.setQuantita(Integer.parseInt(request.getParameter("quantitaModifica")));

        articolo.setTipo(request.getParameter("tipoModifica"));

        articolo.setNovita(request.getParameter("novitaModifica") != null);

        articolo.setSconti(request.getParameter("scontiModifica") != null);

        try {
            articoloDao.doUpdate(articolo);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        response.sendRedirect("Pagine/Home.jsp");

    }

}
