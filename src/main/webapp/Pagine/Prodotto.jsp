<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="Model.Prodotto.ArticoloBean" %>
<%@ page import="Model.ArticoloDao" %>
<%@ page import="java.sql.SQLException" %>

<%
    ArticoloBean articolo=new ArticoloBean();
    ArticoloDao dao=new ArticoloDao();

    try {
        articolo=dao.doGetById(2);
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }

%>
<html>
<head>
    <title>Prodotto - DigiComiX</title>
    <link rel="stylesheet" type="text/css" href="../PagineStile/Prodotto.css?version=1.1">
</head>
<body>
    <!-- header della pagina -->
    <%@ include file="header.jsp" %>

    <!-- visualizzazione del prodotto e degli altri elementi -->
    <div id="prodotto">
        <h1><%= articolo.getNome() %></h1>
        <table>
            <tr>
                <td><img src="../Immagini/Articoli/BoxMagic.png" alt="immagine_prodotto"></td>
                <td><div id="product-info"><h3><%= articolo.getDescrizione() %></h3></div></td>
            </tr>
        </table>
        <h3>Prezzo: <%= articolo.getPrezzo() %></h3>
    </div>

    <!-- tasto carrello che invia i dati al database -->
    <div id="carrello" class="carrello-container">
        <form action="Carrello" method="post">
            <input type="hidden" name="id" value="<%= articolo.getId() %>">
            <input type="hidden" name="nome" value="<%= articolo.getNome() %>">
            <input type="hidden" name="prezzo" value="<%= articolo.getPrezzo() %>">
            <input type="submit" value="Aggiungi al carrello">
        </form>
    </div>

    <div>
        <%@ include file="Footer.jsp" %>
    </div>
</body>
</html>