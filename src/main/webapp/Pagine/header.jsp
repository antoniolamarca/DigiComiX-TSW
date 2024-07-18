
<html>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.getContextPath()}/PagineStile/header.css?=v1.1">
    <script src="<%=request.getContextPath()%>/script/menu'header.js"></script>
</head>
<div id="benvenuto">
    <img id="menuToggle" alt="Logo" src="${pageContext.request.contextPath}/Immagini/Logo.png">
    <h1>Benvenuto ${sessionScope.nome}</h1>
    <!-- icona carrello -->
    <a href="${pageContext.request.contextPath}/Pagine/Carrello.jsp">
        <img alt="carrello" src="${pageContext.request.contextPath}/Immagini/Icone/Carrello.png" class="icone">
    </a>
    <!-- icona profilo -->
    <a href="${pageContext.request.contextPath}/Pagine/Login.jsp">
        <img alt="profilo" src="${pageContext.request.contextPath}/Immagini/Icone/Profilo.png" class="icone">
    </a>
</div>
<!-- menù laterale -->
<div id="sideMenu" class="side-menu">
    <img alt="Logo" src="${pageContext.request.contextPath}/Immagini/Logo.png">
    <span id="closeMenu">&times;</span>
    <ul>
        <li><a href="${pageContext.request.contextPath}/CatalogoServlet?tipo=novita">Novità</a></li>
        <li><a href="${pageContext.request.contextPath}/CatalogoServlet?tipo=sconti">Sconti</a></li>
        <li><a href="${pageContext.request.contextPath}/CatalogoServlet?tipo=manga">Manga</a></li>
        <li><a href="${pageContext.request.contextPath}/CatalogoServlet?tipo=tcg">Trading Card Games</a></li>
        <li><a href="${pageContext.request.contextPath}/CatalogoServlet?tipo=gad">Gadgets & Action figures</a></li>
        <li><a href="${pageContext.request.contextPath}/CatalogoServlet?tipo=gdt">Giochi da Tavolo</a></li>
        <% String requestURL = request.getRequestURI();
            if (!requestURL.endsWith("Home.jsp")) { %>
        <li><a href="${pageContext.request.contextPath}/Pagine/Home.jsp">Torna alla home</a></li>
        <% } %>
    </ul>
</div>