<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="Model.Prodotto.ArticoloBean" %>
<%@ page import="Model.Prodotto.ArticoloDao" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<html>
<head>
    <title>Catalogo Prodotti</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/PagineStile/Catalogo.css?=v1.1">
</head>
<body>
<%@include file="header.jsp" %>
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
<%@include file="Footer.jsp" %>
</body>
</html>
