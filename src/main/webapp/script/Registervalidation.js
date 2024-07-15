
// Otteniamo gli elementi dalla pagina
var inputname = document.getElementById("nome");
var inputcognome = document.getElementById("cognome");
var inputpassword = document.getElementById("password");
var inputemail = document.getElementById("email");
var tasto = document.getElementById("btnReg");

// Funzione per verificare le condizioni
function check() {
    var mail = inputemail.value;
    var password = inputpassword.value;
    var nome = inputname.value;
    var cognome= inputcognome.value;


    // Validazione email e password
    var emailValid = validateEmail(mail);
    var passwordValid = validatePassword(password);
    var nameValid = validateName(nome);
    var surnameValid = validateSurname(cognome);

    if (!emailValid) {
        console.log("Email non valida");
    }
    if (!passwordValid) {
        console.log("Password non valida");
    }
    if (!nameValid) {

    }
    if (!surnameValid) {

    }

    if (emailValid && passwordValid && nameValid && surnameValid) {

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
function validateName(name) {
    var nameRegex = /^[a-zA-Z]{2,20}$/;
    return nameRegex.test(name);
}
function validateSurname(surname) {
    var surnameRegex = /^[a-zA-Z]{2,20}$/;
    return surnameRegex.test(surname);
}

// Aggiungiamo i listener per attendere l'inserimento del campo
inputpassword.addEventListener("input", check);
inputemail.addEventListener("input", check);