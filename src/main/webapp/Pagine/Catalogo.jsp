/<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="Model.Prodotto.ArticoloBean" %>
<%@ page import="Model.Prodotto.ArticoloDao" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<html>
<head>
    <title>Catalogo Prodotti</title>
    <link rel="stylesheet" type="text/css" href="../PagineStile/Catalogo.css">
</head>
<body>
<%
    ArrayList<ArticoloBean> catalogo = (ArrayList<ArticoloBean>) request.getSession().getAttribute("CatalogoFiltrato");
    for(ArticoloBean articolo : catalogo) {
%>

<div class="articolo">
    <img src="${pageContext.request.contextPath}/Immagini/Articoli/<%= articolo.getImages() %>" alt="Immagine di <%= articolo.getNome() %>">
    <h3><%= articolo.getNome() %></h3>
    <p><%= articolo.getDescrizione() %></p>
    <p>Prezzo: €<%= articolo.getPrezzo() %></p>
    <a href="${pageContext.request.contextPath}/ProdottoServlet?ID=<%= articolo.getId() %>">Dettagli</a>
</div>
<% } %>
</body>
</html>
