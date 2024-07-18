<%@ page import="java.util.Collection" %>
<%@ page import="Model.Prodotto.ArticoloBean" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<% Collection<?> prodotti = (Collection<?>) request.getAttribute("Prodotti");
    if (prodotti == null) {
        System.out.println("Raffaele é gay");
        response.sendRedirect(request.getContextPath() + "/HomeServlet");
        return;

    }
    System.out.println(prodotti.size());

%>
<!DOCTYPE html>
<html>
<head>
    <title>Home - DigiComiX</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/PagineStile/Home.css?=v1.4">
    <script src="${pageContext.request.contextPath}/script/funzionihome.js"></script>
</head>
<body>
<%@include file="header.jsp" %>
    <!-- Slider per le novità -->

    <div id="novita" class="titolo">
        <a href="${pageContext.request.contextPath}/CatalogoServlet?tipo=novita"><h1>NOVITÀ</h1></a>
    </div>
    <div class="slider">
        <div class="arrow">
            <img alt="FrecciaSx" src="${pageContext.request.contextPath}/Immagini/Icone/FrecciaL.png">
        </div>
        <% assert prodotti != null;

            int i = 0;
            for(Object o : prodotti) {
                ArticoloBean articolo = (ArticoloBean) o;
                System.out.println("prodoto" + articolo.getNome() + "e "+ articolo.isNovita());
                if(i < 4 && articolo.isNovita()) {

        %>
        <a href="${pageContext.request.contextPath}/ProdottoServlet?ID=<%= articolo.getId() %>"><img src="${pageContext.request.contextPath}/Immagini/Articoli/<%= articolo.getImages() %>" alt="Immagine di <%= articolo.getNome() %>"></a>
        <% }i++;
        }%>
        <div id="right_novita" class="arrow">
            <img alt="FrecciaDx" src="${pageContext.request.contextPath}/Immagini/Icone/FrecciaD.png">
        </div>

    </div>

    <!-- Slider per gli sconti -->
    <div id="sconti" class="titolo">
        <a href="${pageContext.request.contextPath}/CatalogoServlet?tipo=sconti"><h1>SCONTI</h1></a>
    </div>
    <div class="slider">
        <div class="arrow">
            <img alt="FrecciaSx" src="${pageContext.request.contextPath}/Immagini/Icone/FrecciaL.png">
        </div>
        <%

          int isconti = 0;
            for(Object o : prodotti) {
                ArticoloBean articoloSconti= (ArticoloBean) o;
                if(i <= 4 && articoloSconti.isSconti()) {

        %>
        <a href="${pageContext.request.contextPath}/ProdottoServlet?ID=<%= articoloSconti.getId() %>"><img src="${pageContext.request.contextPath}/Immagini/Articoli/<%= articoloSconti.getImages() %>" alt="Immagine di <%= articoloSconti.getNome() %>"></a>
        <% } isconti ++;
        }%>
        <div>
            <img alt="FrecciaDx" src="${pageContext.request.contextPath}/Immagini/Icone/FrecciaD.png">
        </div>
    </div>

<div id="manga" class="titolo">
    <a href="${pageContext.request.contextPath}/CatalogoServlet?tipo=manga"><h1>MANGA</h1></a>
</div>
<!-- slider per i manga -->
<div class="slider">
    <div class="arrow">
        <img alt="FrecciaSx" src="${pageContext.request.contextPath}/Immagini/Icone/FrecciaL.png">
    </div>
    <%
    int imanga = 0;
    for (Object o : prodotti) {
    ArticoloBean manga = (ArticoloBean) o;
    if (imanga < 4 && "manga".equals(manga.getTipo())) {
    %>
    <a href="${pageContext.request.contextPath}/ProdottoServlet?ID=<%= manga.getId() %>">
        <img src="${pageContext.request.contextPath}/Immagini/Articoli/<%= manga.getImages() %>" alt="Immagine di <%= manga.getNome() %>">
    </a>
    <%
        imanga++;
        }
        }
    %>
    <div class="arrow">
        <img alt="FrecciaDx" src="${pageContext.request.contextPath}/Immagini/Icone/FrecciaD.png">
    </div>
</div>
    <!-- slider per i giochi di carte -->
    <div class="titolo">
        <a href="${pageContext.request.contextPath}/CatalogoServlet?tipo=tcg"><h1>TRADING CARD GAMES</h1></a>
    </div>
    <div class="slider">
        <div class="arrow">
            <img alt="FrecciaSx" src="${pageContext.request.contextPath}/Immagini/Icone/FrecciaL.png">
        </div>
        <%
            int itcg = 0;
            for (Object o : prodotti) {
                ArticoloBean tcg = (ArticoloBean) o;
                if (itcg < 3 && "tcg".equals(tcg.getTipo())) {
        %>
        <a href="${pageContext.request.contextPath}/ProdottoServlet?ID=<%= tcg.getId() %>"><img src="${pageContext.request.contextPath}/Immagini/Articoli/<%= tcg.getImages() %>" alt="Immagine di <%= tcg.getNome() %>"></a>
        <%
                    itcg++;
                }
            }
        %>
        <div class="arrow">
            <img alt="FrecciaDx" src="${pageContext.request.contextPath}/Immagini/Icone/FrecciaD.png">
        </div>
    </div>
    <!-- slider per i gadgets -->
    <div class="titolo">
        <a href="${pageContext.request.contextPath}/CatalogoServlet?tipo=gad"><h1>GADGETS & ACTION FIGURES</h1></a>
    </div>
    <div class="slider">
        <div class="arrow">
            <img alt="FrecciaSx" src="${pageContext.request.contextPath}/Immagini/Icone/FrecciaL.png">
        </div>
        <%
            int igad = 0;
            for (Object o : prodotti) {
                ArticoloBean gad = (ArticoloBean) o;
                if (igad < 3 && "gad".equals(gad.getTipo())) {
        %>
        <a href="${pageContext.request.contextPath}/ProdottoServlet?ID=<%= gad.getId() %>"><img src="${pageContext.request.contextPath}/Immagini/Articoli/<%= gad.getImages() %>" alt="Immagine di <%= gad.getNome() %>"></a>
        <%
                    igad++;
                }
            }
        %>
        <div id="right_GAF" class="arrow">
            <img alt="FrecciaDx" src="${pageContext.request.contextPath}/Immagini/Icone/FrecciaD.png">
        </div>
    </div>
    <!-- slider per i giochi da tavolo-->
    <div class="titolo">
        <a href="${pageContext.request.contextPath}/CatalogoServlet?tipo=gdt"><h1>GIOCHI DA TAVOLO</h1></a>
    </div>
    <div class="slider">
        <div class="arrow">
            <img alt="FrecciaSx" src="${pageContext.request.contextPath}/Immagini/Icone/FrecciaL.png">
        </div>
        <%
            int igdt = 0;
            for (Object o : prodotti) {
                ArticoloBean gdt = (ArticoloBean) o;
                if (igdt < 3 && "gdt".equals(gdt.getTipo())) {
        %>
        <a href="${pageContext.request.contextPath}/ProdottoServlet?ID=<%= gdt.getId() %>"><img src="${pageContext.request.contextPath}/Immagini/Articoli/<%= gdt.getImages() %>" alt="Immagine di <%= gdt.getNome() %>"></a>
        <%
                    igdt++;
                }
            }
        %>
        <div id="right_GdT" class="arrow">
            <img alt="FrecciaDx" src="${pageContext.request.contextPath}/Immagini/Icone/FrecciaD.png">
        </div>
    </div>

    <button title="Torna su" class="tornaSu">^</button>

<%@include file="Footer.jsp" %>
</body>
</html>