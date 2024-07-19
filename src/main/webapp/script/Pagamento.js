document.addEventListener('DOMContentLoaded', function() {
    // Ascoltatore per aprire il menu di pagamento
    var checkoutButton = document.querySelector('.bottone_checkout');
    if (checkoutButton) {
        checkoutButton.addEventListener('click', function(event) {
            event.preventDefault(); // Previene il comportamento di default del bottone
            document.getElementById('payment-overlay').style.display = 'flex';
        });
    }

    // Ascoltatore per chiudere il menu di pagamento
    var closeButton = document.getElementById('closePaymentForm');
    if (closeButton) {
        closeButton.addEventListener('click', function() {
            document.getElementById('payment-overlay').style.display = 'none';
        });
    }
});

function submitPaymentInfo() {
    // Qui puoi aggiungere la logica per inviare le informazioni di pagamento al server
    // Per esempio, usando fetch API o XMLHttpRequest
    console.log('Invio informazioni di pagamento...');
    // Chiudi il menu di pagamento dopo l'invio
    document.getElementById('payment-overlay').style.display = 'none';
    alert ("Pagamento effettuato con successo!");
}