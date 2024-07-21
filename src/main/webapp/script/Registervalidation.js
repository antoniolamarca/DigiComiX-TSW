document.addEventListener("DOMContentLoaded", function() {
    console.log("DOM completamente caricato e analizzato");

    // Otteniamo gli elementi dalla pagina
    var inputname = document.getElementById("nome");
    var inputcognome = document.getElementById("cognome");
    var inputpassword = document.getElementById("password");
    var inputemail = document.getElementById("email");
    var tasto = document.getElementById("btnReg");

    // Elementi per i messaggi di errore
    var nomeError = document.getElementById("nomeError");
    var cognomeError = document.getElementById("cognomeError");
    var passwordError = document.getElementById("passwordError");
    var emailError = document.getElementById("emailError");

    // Funzione per verificare le condizioni
    function check() {
        console.log("Funzione di verifica chiamata");

        var mail = inputemail.value;
        var password = inputpassword.value;
        var nome = inputname.value;
        var cognome = inputcognome.value;

        // Validazione email e password
        var emailValid = validateEmail(mail);
        var passwordValid = validatePassword(password);
        var nameValid = validateName(nome);
        var surnameValid = validateSurname(cognome);

        // Messaggi di errore
        if (!emailValid) {
            emailError.textContent = "Inserisci un'email valida.";
        } else {
            emailError.textContent = "";
        }

        if (!passwordValid) {
            passwordError.textContent = "La password deve contenere almeno una lettera maiuscola, una lettera minuscola e un numero, e deve essere lunga tra 4 e 20 caratteri.";
        } else {
            passwordError.textContent = "";
        }

        if (!nameValid) {
            nomeError.textContent = "Il nome deve contenere solo lettere e deve essere lungo tra 2 e 20 caratteri.";
        } else {
            nomeError.textContent = "";
        }

        if (!surnameValid) {
            cognomeError.textContent = "Il cognome deve contenere solo lettere e deve essere lungo tra 2 e 20 caratteri.";
        } else {
            cognomeError.textContent = "";
        }

        // Abilita/disabilita il tasto di registrazione
        tasto.disabled = !(emailValid && passwordValid && nameValid && surnameValid);
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

    // Funzione di validazione nome
    function validateName(name) {
        var nameRegex = /^[a-zA-Z]{2,20}$/;
        return nameRegex.test(name);
    }

    // Funzione di validazione cognome
    function validateSurname(surname) {
        var surnameRegex = /^[a-zA-Z]{2,20}$/;
        return surnameRegex.test(surname);
    }

    // Aggiungiamo i listener per attendere l'inserimento del campo
    inputname.addEventListener("input", check);
    inputcognome.addEventListener("input", check);
    inputpassword.addEventListener("input", check);
    inputemail.addEventListener("input", check);
});