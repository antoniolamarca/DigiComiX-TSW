<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/PagineStile/header.css">
    <script src="<%=request.getContextPath()%>/script/menu'header.js"></script>
</head>
<div id="benvenuto">
    <img id="menuToggle" alt="Logo" src="../Immagini/Logo.png">
    <h1>Benvenuto ${sessionScope.nome}</h1>
    <!-- icona carrello -->
    <a href="Carrello.jsp">
        <img alt="carrello" src="../Immagini/Icone/Carrello.png" class="icone">
    </a>
    <!-- icona profilo -->
    <a href="Login.jsp">
        <img alt="profilo" src="../Immagini/Icone/Profilo.png" class="icone">
    </a>
</div>
<!-- menù laterale -->
<div id="sideMenu" class="side-menu">
    <img alt="Logo" src="../Immagini/Logo.png">
    <span id="closeMenu">&times;</span>
    <ul>
        <li><a href="../Pagine/Novità.jsp">Novità</a></li>
        <li><a href="../Pagine/Sconti.jsp">Sconti</a></li>
        <li><a href="../Pagine/TCG.jsp">Trading Card Games</a></li>
        <li><a href="../Pagine/Gadgets.jsp">Gadgets & Action figures</a></li>
        <li><a href="../Pagine/GdT.jsp">Giochi da Tavolo</a></li>
        <% String requestURL = request.getRequestURI();
            if (!requestURL.endsWith("Home.jsp")) { %>
        <li><a href="../Pagine/Home.jsp">Torna alla home</a></li>
        <% } %>
    </ul>
</div>