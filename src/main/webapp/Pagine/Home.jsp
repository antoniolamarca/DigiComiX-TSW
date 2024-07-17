<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Home - DigiComiX</title>
    <link rel="stylesheet" type="text/css" href="../PagineStile/Home.css?=v1.1">
    <script src="../script/funzionihome.js"></script>
</head>
<body>
<%@include file="header.jsp" %>
    <!-- Slider per le novità -->
    <div id="novita" class="titolo">
        <a href="../Pagine/Novità.jsp"><h1>NOVITÀ</h1></a>
    </div>
    <div id="slider_novita">
        <div id="left_novita">
            <img id="prev_novita" alt="FrecciaSx" src="../Immagini/Icone/FrecciaL.png">
        </div>
        <img alt="Berserk Vol.1" src="../Immagini/Articoli/BerserkCop.jpg">
        <img alt="ChainsawMan Vol.1" src="../Immagini/Articoli/CopChainsawMan.jpg">
        <img alt="Darling In The FranXX Vol.1" src="../Immagini/Articoli/DarlingXX.jpg">
        <img alt="DragonBall Vol.1" src="../Immagini/Articoli/DragonBallCop.jpg">
        <img alt="Shaman King Vol.1" src="../Immagini/Articoli/ShamanCop.jpg">
        <div id="right_novita">
            <img id="next_novita" alt="FrecciaDx" src="../Immagini/Icone/FrecciaD.png">
        </div>
    </div>
    <!-- Slider per gli sconti -->
    <div id="sconti" class="titolo">
        <a href="../Pagine/Sconti.jsp"><h1>SCONTI</h1></a>
    </div>
    <div id="slider_sconti">
        <div id="left_sconti">
            <img id="prev_sconti" alt="FrecciaSx" src="../Immagini/Icone/FrecciaL.png">
        </div>
        <img alt="Berserk Vol.1" src="../Immagini/Articoli/BerserkCop.jpg">
        <img alt="ChainsawMan Vol.1" src="../Immagini/Articoli/CopChainsawMan.jpg">
        <img alt="Darling In The FranXX Vol.1" src="../Immagini/Articoli/DarlingXX.jpg">
        <img alt="DragonBall Vol.1" src="../Immagini/Articoli/DragonBallCop.jpg">
        <img alt="Shaman King Vol.1" src="../Immagini/Articoli/ShamanCop.jpg">
        <div id="right_sconti">
            <img id="next_sconti" alt="FrecciaDx" src="../Immagini/Icone/FrecciaD.png">
        </div>
    </div>
    <!-- slider per i giochi di carte -->
    <div id="TCG" class="titolo">
        <a href="../Pagine/TCG.jsp"><h1>TRADING CARD GAMES</h1></a>
    </div>
    <div id="slider_TCG">
        <div id="left_TCG">
            <img id="prev_TCG" alt="FrecciaSx" src="../Immagini/Icone/FrecciaL.png">
        </div>
        <img alt="Berserk Vol.1" src="../Immagini/Articoli/BerserkCop.jpg">
        <img alt="ChainsawMan Vol.1" src="../Immagini/Articoli/CopChainsawMan.jpg">
        <img alt="Darling In The FranXX Vol.1" src="../Immagini/Articoli/DarlingXX.jpg">
        <img alt="DragonBall Vol.1" src="../Immagini/Articoli/DragonBallCop.jpg">
        <img alt="Shaman King Vol.1" src="../Immagini/Articoli/ShamanCop.jpg">
        <div id="right_TCG">
            <img id="next_TCG" alt="FrecciaDx" src="../Immagini/Icone/FrecciaD.png">
        </div>
    </div>
    <!-- slider per i gadgets -->
    <div id="GAF" class="titolo">
        <a href="../Pagine/Gadgets.jsp"><h1>GADGETS & ACTION FIGURES</h1></a>
    </div>
    <div id="slider_GAF">
        <div id="left_GAF">
            <img id="prev_GAF" alt="FrecciaSx" src="../Immagini/Icone/FrecciaL.png">
        </div>
        <img alt="Berserk Vol.1" src="../Immagini/Articoli/BerserkCop.jpg">
        <img alt="ChainsawMan Vol.1" src="../Immagini/Articoli/CopChainsawMan.jpg">
        <img alt="Darling In The FranXX Vol.1" src="../Immagini/Articoli/DarlingXX.jpg">
        <img alt="DragonBall Vol.1" src="../Immagini/Articoli/DragonBallCop.jpg">
        <img alt="Shaman King Vol.1" src="../Immagini/Articoli/ShamanCop.jpg">
        <div id="right_GAF">
            <img id="next_GAF" alt="FrecciaDx" src="../Immagini/Icone/FrecciaD.png">
        </div>
    </div>
    <!-- slider per i giochi da tavolo-->
    <div id="GdT" class="titolo">
        <a href="${pageContext.request.contextPath}/CatalogoServlet?tipo=gdt"><h1>GIOCHI DA TAVOLO</h1></a>
    </div>
    <div id="slider_GdT">
        <div id="left_GdT">
            <img id="prev_GdT" alt="FrecciaSx" src="../Immagini/Icone/FrecciaL.png">
        </div>
        <img alt="Berserk Vol.1" src="../Immagini/Articoli/BerserkCop.jpg">
        <img alt="ChainsawMan Vol.1" src="../Immagini/Articoli/CopChainsawMan.jpg">
        <img alt="Darling In The FranXX Vol.1" src="../Immagini/Articoli/DarlingXX.jpg">
        <img alt="DragonBall Vol.1" src="../Immagini/Articoli/DragonBallCop.jpg">
        <img alt="Shaman King Vol.1" src="../Immagini/Articoli/ShamanCop.jpg">
        <div id="right_GdT">
            <img id="next_GdT" alt="FrecciaDx" src="../Immagini/Icone/FrecciaD.png">
        </div>
    </div>

    <button id="tornaSu" title="Torna su">^</button>

    <%@include file="Footer.jsp" %>
</body>
</html>