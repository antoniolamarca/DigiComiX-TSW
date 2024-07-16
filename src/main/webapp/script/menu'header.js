document.addEventListener('DOMContentLoaded', function() {


// Codice per aprire il menù laterale
  document.getElementById('menuToggle').addEventListener('click', function () {
    let menu = document.getElementById('sideMenu');
    menu.classList.toggle('open');
  });

// Codice per chiudere il menù laterale
  document.getElementById('closeMenu').addEventListener('click', function () {
    let menu = document.getElementById('sideMenu');
    menu.classList.remove('open');
  });

});