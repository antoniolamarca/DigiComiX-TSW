<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="Model.Prodotto.ArticoloBean" %>
<%@ page import="Model.Prodotto.ArticoloDao" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<html>
<head>
    <title>Catalogo Prodotti</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/PagineStile/Catalogo.css?=v1.5">

</head>
<body>


<%@include file="../Fragments/header.jsp" %>

<input type="text" id="searchbar">
<button type="button" onclick="ajax_searchbar()">Cerca nel nostro catalogo</button>

<div id="catalogo">
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
    </div>
<%@include file="../Fragments/Footer.jsp" %>
<script src="${pageContext.request.contextPath}/script/ajax_searchbar.js"></script>
</body>
</html>
