<%@ page import="java.util.List" %>
<%@ page import="Model.Prodotto.ArticoloBean" %>
<%@ page import="Model.ArticoloDao" %>
<%@ page import="java.sql.SQLException" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    ArticoloDao dao = new ArticoloDao();
    List<ArticoloBean> articoli = null;
    double totale = 0;

    try {
        // Assumi che esista un metodo per ottenere tutti gli articoli nel carrello
        articoli = dao.getArticoliNelCarrello();
        for (ArticoloBean articolo : articoli) {
            totale += articolo.getPrezzo();
        }
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
%>
<html>
<head>
    <title>Carrello - DigiComiX</title>
    <link rel="stylesheet" type="text/css" href="../PagineStile/Carrello.css">
</head>
<body>

<div>
    <%@include file="header.jsp" %>
</div>

<!-- Contenuto del carrello -->

<div id="checkout" class="acquisto-container">
    <form action="acquista" method="post">
        <% for (ArticoloBean articolo : articoli) { %>
        <input type="hidden" name="id" value="<%= articolo.getId() %>">
        <input type="hidden" name="nome" value="<%= articolo.getNome() %>">
        <input type="hidden" name="prezzo" value="<%= articolo.getPrezzo() %>">
        <% } %>
        <input type="submit" value="Procedi al pagamento (Totale: €<%= totale %>)">
    </form>
</div>
<div>
    <%@include file="Footer.jsp"%>
</div>

</body>
</html>
<html>
<head>
    <title>Prodotto - DigiComiX</title>
    <link rel="stylesheet" type="text/css" href="../PagineStile/Prodotto?version=1.1">
</head>
<body>

<div>
    <%@include file="header.jsp" %>
</div>

<div id="prodotto" class="prodotto-container">
    <h1><%=articolo.getNome()%></h1>
    <img src="../Immagini/Articoli/BerserkCop.jpg" alt="immagine_prodotto">
    <p><%=articolo.getDescrizione()%></p>
    <span><%=articolo.getPrezzo()%></span>
</div>

<div id="acquisto" class="acquisto-container">
    <form action="acquista" method="post">
        <% for (ArticoloBean articolo : articoli) { %>
        <input type="hidden" name="id" value="<%= articolo.getId() %>">
        <input type="hidden" name="nome" value="<%= articolo.getNome() %>">
        <input type="hidden" name="prezzo" value="<%= articolo.getPrezzo() %>">
        <% } %>
        <input type="submit" value="Procedi al pagamento (Totale: €<%= totale %>)">
    </form>
</div>
<div>
    <%@include file="Footer.jsp"%>
</div>

</body>
</html>
