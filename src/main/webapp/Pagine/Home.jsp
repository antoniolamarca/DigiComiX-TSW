<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Home - DigiComiX</title>
    <link rel="stylesheet" type="text/css" href="../PagineStile/Home.css?=v1.3">
    <script src="../script/funzionihome.js"></script>
</head>
<body>
<%@include file="header.jsp" %>
    <!-- Slider per le novità -->
    <div id="novita" class="titolo">
        <a href="${pageContext.request.contextPath}/CatalogoServlet?tipo=novita"><h1>NOVITÀ</h1></a>
    </div>
    <div class="slider">
        <div class="arrow">
            <img alt="FrecciaSx" src="../Immagini/Icone/FrecciaL.png">
        </div>
        <img alt="Berserk Vol.1" src="../Immagini/Articoli/1.jpg">
        <img alt="ChainsawMan Vol.1" src="../Immagini/Articoli/CopChainsawMan.jpg">
        <img alt="Darling In The FranXX Vol.1" src="../Immagini/Articoli/DarlingXX.jpg">
        <img alt="DragonBall Vol.1" src="../Immagini/Articoli/DragonBallCop.jpg">
        <img alt="Shaman King Vol.1" src="../Immagini/Articoli/ShamanCop.jpg">
        <div id="right_novita" class="arrow">
            <img alt="FrecciaDx" src="../Immagini/Icone/FrecciaD.png">
        </div>
    </div>
    <!-- Slider per gli sconti -->
    <div id="sconti" class="titolo">
        <a href="${pageContext.request.contextPath}/CatalogoServlet?tipo=sconti"><h1>SCONTI</h1></a>
    </div>
    <div class="slider">
        <div class="arrow">
            <img alt="FrecciaSx" src="../Immagini/Icone/FrecciaL.png">
        </div>
        <img alt="Berserk Vol.1" src="../Immagini/Articoli/1.jpg">
        <img alt="ChainsawMan Vol.1" src="../Immagini/Articoli/CopChainsawMan.jpg">
        <img alt="Darling In The FranXX Vol.1" src="../Immagini/Articoli/DarlingXX.jpg">
        <img alt="DragonBall Vol.1" src="../Immagini/Articoli/DragonBallCop.jpg">
        <img alt="Shaman King Vol.1" src="../Immagini/Articoli/ShamanCop.jpg">
        <div id="right_sconti" class="arrow">
            <img alt="FrecciaDx" src="../Immagini/Icone/FrecciaD.png">
        </div>
    </div>
<div id="manga" class="titolo">
    <a href="${pageContext.request.contextPath}/CatalogoServlet?tipo=manga"><h1>MANGA</h1></a>
</div>
<!-- slider per i manga -->
<div class="slider">
    <div class="arrow">
        <img alt="FrecciaSx" src="../Immagini/Icone/FrecciaL.png">
    </div>
    <img alt="Berserk Vol.1" src="../Immagini/Articoli/1.jpg">
    <img alt="ChainsawMan Vol.1" src="../Immagini/Articoli/CopChainsawMan.jpg">
    <img alt="Darling In The FranXX Vol.1" src="../Immagini/Articoli/DarlingXX.jpg">
    <img alt="DragonBall Vol.1" src="../Immagini/Articoli/DragonBallCop.jpg">
    <img alt="Shaman King Vol.1" src="../Immagini/Articoli/ShamanCop.jpg">
    <div class="arrow">
        <img alt="FrecciaDx" src="../Immagini/Icone/FrecciaD.png">
    </div>
</div>
    <!-- slider per i giochi di carte -->
    <div class="titolo">
        <a href="${pageContext.request.contextPath}/CatalogoServlet?tipo=tcg"><h1>TRADING CARD GAMES</h1></a>
    </div>
    <div class="slider">
        <div class="arrow">
            <img alt="FrecciaSx" src="../Immagini/Icone/FrecciaL.png">
        </div>
        <img alt="Berserk Vol.1" src="../Immagini/Articoli/1.jpg">
        <img alt="ChainsawMan Vol.1" src="../Immagini/Articoli/CopChainsawMan.jpg">
        <img alt="Darling In The FranXX Vol.1" src="../Immagini/Articoli/DarlingXX.jpg">
        <img alt="DragonBall Vol.1" src="../Immagini/Articoli/DragonBallCop.jpg">
        <img alt="Shaman King Vol.1" src="../Immagini/Articoli/ShamanCop.jpg">
        <div class="arrow">
            <img alt="FrecciaDx" src="../Immagini/Icone/FrecciaD.png">
        </div>
    </div>
    <!-- slider per i gadgets -->
    <div class="titolo">
        <a href="${pageContext.request.contextPath}/CatalogoServlet?tipo=gad"><h1>GADGETS & ACTION FIGURES</h1></a>
    </div>
    <div class="slider">
        <div class="arrow">
            <img alt="FrecciaSx" src="../Immagini/Icone/FrecciaL.png">
        </div>
        <img alt="Berserk Vol.1" src="../Immagini/Articoli/1.jpg">
        <img alt="ChainsawMan Vol.1" src="../Immagini/Articoli/CopChainsawMan.jpg">
        <img alt="Darling In The FranXX Vol.1" src="../Immagini/Articoli/DarlingXX.jpg">
        <img alt="DragonBall Vol.1" src="../Immagini/Articoli/DragonBallCop.jpg">
        <img alt="Shaman King Vol.1" src="../Immagini/Articoli/ShamanCop.jpg">
        <div id="right_GAF" class="arrow">
            <img alt="FrecciaDx" src="../Immagini/Icone/FrecciaD.png">
        </div>
    </div>
    <!-- slider per i giochi da tavolo-->
    <div class="titolo">
        <a href="${pageContext.request.contextPath}/CatalogoServlet?tipo=gdt"><h1>GIOCHI DA TAVOLO</h1></a>
    </div>
    <div class="slider">
        <div class="arrow">
            <img alt="FrecciaSx" src="../Immagini/Icone/FrecciaL.png">
        </div>
        <img alt="Berserk Vol.1" src="../Immagini/Articoli/1.jpg">
        <img alt="ChainsawMan Vol.1" src="../Immagini/Articoli/CopChainsawMan.jpg">
        <img alt="Darling In The FranXX Vol.1" src="../Immagini/Articoli/DarlingXX.jpg">
        <img alt="DragonBall Vol.1" src="../Immagini/Articoli/DragonBallCop.jpg">
        <img alt="Shaman King Vol.1" src="../Immagini/Articoli/ShamanCop.jpg">
        <div id="right_GdT" class="arrow">
            <img alt="FrecciaDx" src="../Immagini/Icone/FrecciaD.png">
        </div>
    </div>

    <button title="Torna su" class="tornaSu">^</button>

    <%@include file="Footer.jsp" %>
</body>
</html>