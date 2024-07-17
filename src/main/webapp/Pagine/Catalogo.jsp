<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="Model.Prodotto.ArticoloBean" %>
<%@ page import="Model.Prodotto.ArticoloDao" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <title>Catalogo Prodotti</title>
    <link rel="stylesheet" type="text/css" href="../PagineStile/Catalogo.css">
</head>
<body>
<%
    ArticoloDao dao = new ArticoloDao();
    List<ArticoloBean> articoli = dao.getAllArticoli(); // Assumendo che esista un metodo per recuperare tutti gli articoli
    for(ArticoloBean articolo : articoli) {
%>
<div class="articolo">
    <img src="<%= articolo.getImmagineUrl() %>" alt="Immagine di <%= articolo.getNome() %>">
    <h3><%= articolo.getNome() %></h3>
    <p><%= articolo.getDescrizione() %></p>
    <p>Prezzo: €<%= articolo.getPrezzo() %></p>
    <a href="Prodotto.jsp?id=<%= articolo.getId() %>">Dettagli</a>
</div>
<% } %>
</body>
</html>
