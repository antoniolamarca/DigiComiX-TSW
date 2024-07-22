document.addEventListener("DOMContentLoaded", function() {
  console.log("DOM completamente caricato e analizzato");

  // Otteniamo gli elementi dalla pagina
  var inputPassword = document.getElementById("password");
  var inputEmail = document.getElementById("email");
  var tasto = document.getElementById("btnLogin");

  // Elementi per i messaggi di errore
  var passwordError = document.getElementById("passwordError");
  var emailError = document.getElementById("emailError");

  // Funzione di validazione email
  function validateEmail(email) {
    var emailRegex = /^[a-zA-Z0-9_+&*-]+(?:\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\.)+[a-zA-Z]{2,7}$/;
    return emailRegex.test(email);
  }

  // Funzione di validazione password
  function validatePassword(password) {
    var passwordRegex = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{4,20}$/;
    return passwordRegex.test(password);
  }



  // Funzione per verificare le condizioni
  function check(event) {
    console.log("Funzione di verifica chiamata");

    // Otteniamo i valori dei campi
    var mail = inputEmail.value;
    var password = inputPassword.value;


    // Determiniamo quale campo è stato modificato
    var target = event.target;

    // Validazione per il campo modificato
    if (target === inputEmail) {
      emailError.textContent = validateEmail(mail) ? "" : "Inserisci un'email valida.";
    } else if (target === inputPassword) {
      passwordError.textContent = validatePassword(password) ? "" : "La password deve contenere almeno una lettera maiuscola, una lettera minuscola e un numero, e deve essere lunga tra 4 e 20 caratteri.";
    }


    // Abilita/disabilita il tasto di registrazione
    tasto.disabled = !(validateEmail(mail) && validatePassword(password));
  }

  // Funzione debounce
  function debounce(func, delay) {
    let timer;
    return function(...args) {
      clearTimeout(timer);
      timer = setTimeout(() => func.apply(this, args), delay);
    };
  }

  // Aggiungiamo i listener per attendere l'inserimento del campo
  const debouncedCheck = debounce(check, 300); // 300 ms di debounce
  inputPassword.addEventListener("input", debouncedCheck);
  inputEmail.addEventListener("input", debouncedCheck);
});