<%@ page import="Model.Prodotto.ArticoloBean" %>
<%@ page import="Model.ArticoloDao" %>
<%@ page import="java.sql.SQLException" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
<div id="carrello" class="carrello-container">
    <form action="Carrello" method="post">
        <input type="hidden" name="id" value="<%=articolo.getId()%>">
        <input type="hidden" name="nome" value="<%=articolo.getNome()%>">
        <input type="hidden" name="prezzo" value="<%=articolo.getPrezzo()%>">
        <input type="submit" value="Aggiungi al carrello">
    </form>
</div>


<div>
 <%@include file="Footer.jsp"%>
</div>

</body>
</html>