<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Home - DigiComiX</title>
    <link rel="stylesheet" type="text/css" href="../PagineStile/Home.css">
</head>
<body>
    <div id="benvenuto">
        <img id="menuToggle" alt="Logo" src="../Immagini/Logo.png">
        <h1>Benvenuto User!</h1>
        <a href="Carrello.jsp">
            <img alt="carrello" src="../Immagini/Icone/Carrello.png" class="icone">
        </a>
        <img alt="profilo" src="../Immagini/Icone/Profilo.png" class="icone">
    </div>
    <div id="sideMenu" class="side-menu">
        <img alt="Logo" src="../Immagini/Logo.png">
        <span id="closeMenu">&times;</span>
        <ul>
            <li><a href="../Pagine/Novità.jsp">Novità</a></li>
            <li><a href="../Pagine/Sconti.jsp">Sconti</a></li>
            <li><a href="../Pagine/TCG.jsp">Trading Card Games</a></li>
            <li><a href="../Pagine/Gadgets.jsp">Gadgets & Action figures</a></li>
            <li><a href="../Pagine/GdT.jsp">Giochi da Tavolo</a></li>
        </ul>
    </div>
    <div id="novita" class="titolo">
        <a href="../Pagine/Novità.jsp"><h1>NOVITÀ</h1></a>
    </div>
    <div id="slider_novita">
        <button id="prev_novita">Prev</button>
        <img alt="Berserk Vol.1" src="../Immagini/Articoli/BerserkCop.jpg">
        <img alt="ChainsawMan Vol.1" src="../Immagini/Articoli/CopChainsawMan.jpg">
        <img alt="Darling In The FranXX Vol.1" src="../Immagini/Articoli/DarlingXX.jpg">
        <img alt="DragonBall Vol.1" src="../Immagini/Articoli/DragonBallCop.jpg">
        <img alt="Shaman King Vol.1" src="../Immagini/Articoli/ShamanCop.jpg">
        <button id="next_novita">Next</button>
    </div>
    <div id="sconti" class="titolo">
        <a href="../Pagine/Sconti.jsp"><h1>SCONTI</h1></a>
    </div>
    <div id="slider_sconti">
        <button id="prev_sconti">Prev</button>
        <img alt="Berserk Vol.1" src="../Immagini/Articoli/BerserkCop.jpg">
        <img alt="ChainsawMan Vol.1" src="../Immagini/Articoli/CopChainsawMan.jpg">
        <img alt="Darling In The FranXX Vol.1" src="../Immagini/Articoli/DarlingXX.jpg">
        <img alt="DragonBall Vol.1" src="../Immagini/Articoli/DragonBallCop.jpg">
        <img alt="Shaman King Vol.1" src="../Immagini/Articoli/ShamanCop.jpg">
        <button id="next_sconti">Next</button>
    </div>
    <div id="TCG" class="titolo">
        <a href="../Pagine/TCG.jsp"><h1>TRADING CARD GAMES</h1></a>
    </div>
    <div id="slider_TCG">
        <button id="prev_TCG">Prev</button>
        <img alt="Berserk Vol.1" src="../Immagini/Articoli/BerserkCop.jpg">
        <img alt="ChainsawMan Vol.1" src="../Immagini/Articoli/CopChainsawMan.jpg">
        <img alt="Darling In The FranXX Vol.1" src="../Immagini/Articoli/DarlingXX.jpg">
        <img alt="DragonBall Vol.1" src="../Immagini/Articoli/DragonBallCop.jpg">
        <img alt="Shaman King Vol.1" src="../Immagini/Articoli/ShamanCop.jpg">
        <button id="next_TCG">Next</button>
    </div>
    <div id="GAF" class="titolo">
        <a href="../Pagine/Gadgets.jsp"><h1>GADGETS & ACTION FIGURES</h1></a>
    </div>
    <div id="slider_GAF">
        <button id="prev_GAF">Prev</button>
        <img alt="Berserk Vol.1" src="../Immagini/Articoli/BerserkCop.jpg">
        <img alt="ChainsawMan Vol.1" src="../Immagini/Articoli/CopChainsawMan.jpg">
        <img alt="Darling In The FranXX Vol.1" src="../Immagini/Articoli/DarlingXX.jpg">
        <img alt="DragonBall Vol.1" src="../Immagini/Articoli/DragonBallCop.jpg">
        <img alt="Shaman King Vol.1" src="../Immagini/Articoli/ShamanCop.jpg">
        <button id="next_GAF">Next</button>
    </div>
    <div id="GdT" class="titolo">
        <a href="../Pagine/GdT.jsp"><h1>GIOCHI DA TAVOLO</h1></a>
    </div>
    <div id="slider_GdT">
        <button id="prev_GdT">Prev</button>
        <img alt="Berserk Vol.1" src="../Immagini/Articoli/BerserkCop.jpg">
        <img alt="ChainsawMan Vol.1" src="../Immagini/Articoli/CopChainsawMan.jpg">
        <img alt="Darling In The FranXX Vol.1" src="../Immagini/Articoli/DarlingXX.jpg">
        <img alt="DragonBall Vol.1" src="../Immagini/Articoli/DragonBallCop.jpg">
        <img alt="Shaman King Vol.1" src="../Immagini/Articoli/ShamanCop.jpg">
        <button id="next_GdT">Next</button>
    </div>

    <button id="tornaSu" title="Torna su">^</button>
    <script>
        // Codice per cambiare immagini negli slider novità
        const imagesNovita = document.querySelectorAll('#slider_novita img');
        const btnPrevNovita = document.getElementById('prev_novita');
        const btnNextNovita = document.getElementById('next_novita');

        let currentIndexNovita = 0;
        imagesNovita[currentIndexNovita].style.display = 'block';

        function showImageNovita(index){
            imagesNovita.forEach(img => img.style.display = 'none');
            imagesNovita[index].style.display = 'block';
        }

        btnPrevNovita.addEventListener('click', () => {
            currentIndexNovita = (currentIndexNovita - 1 + imagesNovita.length) % imagesNovita.length;
            showImageNovita(currentIndexNovita);
        });

        btnNextNovita.addEventListener('click', () => {
            currentIndexNovita = (currentIndexNovita + 1) % imagesNovita.length;
            showImageNovita(currentIndexNovita);
        });

        // codice per cambiare le immagini nello slider sconti
        const imagesSconti = document.querySelectorAll('#slider_sconti img');
        const btnPrevSconti = document.getElementById('prev_sconti');
        const btnNextSconti = document.getElementById('next_sconti');

        let currentIndexSconti = 0;
        imagesSconti[currentIndexSconti].style.display = 'block';

        function showImageSconti(index) {
            imagesSconti.forEach(img => img.style.display = 'none');
            imagesSconti[index].style.display = 'block';
        }

        btnPrevSconti.addEventListener('click', () => {
            currentIndexSconti = (currentIndexSconti - 1 + imagesSconti.length) % imagesSconti.length;
            showImageSconti(currentIndexSconti);
        });

        btnNextSconti.addEventListener('click', () => {
            currentIndexSconti = (currentIndexSconti + 1) % imagesSconti.length;
            showImageSconti(currentIndexSconti);
        });

        // codice per cambiare le immagini nello slider TCG
        const imagesTCG = document.querySelectorAll('#slider_TCG img');
        const btnPrevTCG = document.getElementById('prev_TCG');
        const btnNextTCG = document.getElementById('next_TCG');

        let currentIndexTCG = 0;
        imagesTCG[currentIndexTCG].style.display = 'block';

        function showImageTCG(index) {
            imagesTCG.forEach(img => img.style.display = 'none');
            imagesTCG[index].style.display = 'block';
        }

        btnPrevTCG.addEventListener('click', () => {
            currentIndexTCG = (currentIndexTCG - 1 + imagesTCG.length) % imagesTCG.length;
            showImageTCG(currentIndexTCG);
        });

        btnNextTCG.addEventListener('click', () => {
            currentIndexTCG = (currentIndexTCG + 1) % imagesTCG.length;
            showImageTCG(currentIndexTCG);
        });

        // codice per cambiare le immagini nello slider GAF
        const imagesGAF = document.querySelectorAll('#slider_GAF img');
        const btnPrevGAF = document.getElementById('prev_GAF');
        const btnNextGAF = document.getElementById('next_GAF');

        let currentIndexGAF = 0;
        imagesGAF[currentIndexGAF].style.display = 'block';

        function showImageGAF(index) {
            imagesGAF.forEach(img => img.style.display = 'none');
            imagesGAF[index].style.display = 'block';
        }

        btnPrevGAF.addEventListener('click', () => {
            currentIndexGAF = (currentIndexGAF - 1 + imagesGAF.length) % imagesGAF.length;
            showImageGAF(currentIndexGAF);
        });

        btnNextGAF.addEventListener('click', () => {
            currentIndexGAF = (currentIndexGAF + 1) % imagesGAF.length;
            showImageGAF(currentIndexGAF);
        });

        // codice per cambiare le immagini nello slider GdT
        const imagesGdT = document.querySelectorAll('#slider_GdT img');
        const btnPrevGdT = document.getElementById('prev_GdT');
        const btnNextGdT = document.getElementById('next_GdT');

        let currentIndexGdT = 0;
        imagesGdT[currentIndexGdT].style.display = 'block';

        function showImageGdT(index) {
            imagesGdT.forEach(img => img.style.display = 'none');
            imagesGdT[index].style.display = 'block';
        }

        btnPrevGdT.addEventListener('click', () => {
            currentIndexGdT = (currentIndexGdT - 1 + imagesGdT.length) % imagesGdT.length;
            showImageGdT(currentIndexGdT);
        });

        btnNextGdT.addEventListener('click', () => {
            currentIndexGdT = (currentIndexGdT + 1) % imagesGdT.length;
            showImageGdT(currentIndexGdT);
        });

        // Codice per aprire il menù laterale
        document.getElementById('menuToggle').addEventListener('click', function() {
            let menu = document.getElementById('sideMenu');
            menu.classList.toggle('open');
        });

        // Codice per chiudere il menù laterale
        document.getElementById('closeMenu').addEventListener('click', function() {
            let menu = document.getElementById('sideMenu');
            menu.classList.remove('open');
        });

        // Codice per tornare su
        window.onscroll = function() {scrollFunction()};

        function scrollFunction() {
            if (document.body.scrollTop > 20 || document.documentElement.scrollTop > 20) {
                document.getElementById("tornaSu").style.display = "block";
            } else {
                document.getElementById("tornaSu").style.display = "none";
            }
        }

        // Quando l'utente clicca sul pulsante, scorri verso l'alto della pagina
        document.getElementById("tornaSu").addEventListener("click", function() {
            document.body.scrollTop = 0; // Per Safari
            document.documentElement.scrollTop = 0; // Per Chrome, Firefox, IE e Opera
        });
  </script>
    <%@include file="Footer.jsp" %>
</body>
</html>