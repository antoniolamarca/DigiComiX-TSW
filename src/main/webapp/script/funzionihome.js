document.addEventListener('DOMContentLoaded', function() {

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

});