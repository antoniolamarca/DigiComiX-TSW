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
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/CercaArticoli")
public class CercaArticoli extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String search = request.getParameter("text");
        HttpSession session = request.getSession();
        ArrayList<ArticoloBean> catalogo = (ArrayList<ArticoloBean>) session.getAttribute("CatalogoFiltrato");
        ArrayList<ArticoloBean> catalogofiltrato = null;
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        if (search != null && !search.trim().isEmpty()) {
             catalogofiltrato = filterCatalogoByQuery(catalogo,search);
            if (catalogofiltrato != null) {

                for (ArticoloBean articolo : catalogofiltrato) {
                    out.println("<div class=\"articolo\">");
                    out.println("<img src=\""+ request.getContextPath() +"/Immagini/Articoli/" + articolo.getImages() +"\" alt=\"Immagine di " + articolo.getNome() + "\">");
                    out.println("<h3>" + articolo.getNome() + "</h3>");
                    out.println("<p>" + articolo.getDescrizione() + "</p>");
                    out.println("<p>Prezzo: €" + articolo.getPrezzo() + "</p>");
                    out.println("<a href=\""+ request.getContextPath() +"/ProdottoServlet?ID=" +  articolo.getId()  + "\">Dettagli</a>");
                    out.println("</div>");
                }
            } else {
                out.println("<p>Nessun articolo trovato.</p>");
            }
        } else {
            for (ArticoloBean articolo : catalogo) {
                out.println("<div class=\"articolo\">");
                out.println("<img src=\""+ request.getContextPath() +"/Immagini/Articoli/" + articolo.getImages() +"\" alt=\"Immagine di " + articolo.getNome() + "\">");
                out.println("<h3>" + articolo.getNome() + "</h3>");
                out.println("<p>" + articolo.getDescrizione() + "</p>");
                out.println("<p>Prezzo: €" + articolo.getPrezzo() + "</p>");
                out.println("<a href=\""+ request.getContextPath() +"/ProdottoServlet?ID=" +  articolo.getId()  + "\">Dettagli</a>");
                out.println("</div>");
            }
        }






    }

    private ArrayList<ArticoloBean> filterCatalogoByQuery(List<ArticoloBean> catalogo, String query) {
        ArrayList<ArticoloBean> filteredCatalogo = new ArrayList<>();
        for (ArticoloBean articolo : catalogo) {
            if (articolo.getNome().toLowerCase().contains(query.toLowerCase()) ||
                    articolo.getDescrizione().toLowerCase().contains(query.toLowerCase())) {
                System.out.println(articolo.getNome());
                filteredCatalogo.add(articolo);
            }
        }
        return filteredCatalogo;
    }


}
