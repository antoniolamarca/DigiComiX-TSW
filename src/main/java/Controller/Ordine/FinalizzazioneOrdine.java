package Controller.Ordine;

import Model.Carrello.Cart;
import Model.Ordine.OrdineDao;
import Model.Ordine.OrdineBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;


@WebServlet("/EffettuaOrdine")
public class FinalizzazioneOrdine extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if(req.getSession().getAttribute("cart") != null) {
            //Prendiamo il carrello dalla sessione
            Cart cart = (Cart) req.getSession().getAttribute("cart");
            if(!cart.getCarrello().isEmpty()) {
                //Se il carrello non è vuoto:
                OrdineDao ordineDao = new OrdineDao();
                OrdineBean ordineBean = new OrdineBean();

                //Popoliamo l'ordine:
                ordineBean.setData_ordine(LocalDate.now());
                ordineBean.setId_utente((Integer) req.getSession().getAttribute("idUtente"));

                try {
                    ordineBean.setProdotti_ordinati( cart);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                ordineBean.setIndirizzo(req.getParameter("address"));

                for(int i = 0; i < cart.getCarrello().size(); i++) {
                    ordineBean.setPrezzo(ordineBean.getPrezzo() + cart.getCarrello().get(i).getPrezzo());
                }

                req.getSession().removeAttribute("cart");
                try {
                    ordineDao.doSave(ordineBean);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }

                resp.sendRedirect("Pagine/Home.jsp");

            }
        }
    }
}
