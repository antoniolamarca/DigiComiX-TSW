// Otteniamo gli elementi dalla pagina
var inputPassword = document.getElementById("password");
var inputEmail = document.getElementById("email");
var tasto = document.getElementById("btnLogin");
var emailError = document.getElementById("emailError");
var passwordError = document.getElementById("passwordError");

// Funzione per verificare le condizioni
function check() {
  var mail = inputEmail.value;
  var password = inputPassword.value;

  // Validazione email e password
  var emailValid = validateEmail(mail);
  var passwordValid = validatePassword(password);



  // Abilita o disabilita il pulsante in base alla validazione
  if (emailValid && passwordValid) {
    tasto.disabled = false;
  } else {
    tasto.disabled = true;
  }
}

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

// Aggiungiamo i listener per attendere l'inserimento del campo
inputPassword.addEventListener("input", check);
inputEmail.addEventListener("input", check);

// Ascoltatore di eventi blur per il campo email
inputEmail.addEventListener("blur", function() {
  var emailValid = validateEmail(inputEmail.value);
  emailError.textContent = emailValid ? '' : 'Email non valida';
});

// Ascoltatore di eventi blur per il campo password
inputPassword.addEventListener("blur", function() {
  var passwordValid = validatePassword(inputPassword.value);
  passwordError.textContent = passwordValid ? '' : 'Password non valida';
});