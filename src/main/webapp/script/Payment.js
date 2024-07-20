document.addEventListener("DOMContentLoaded", function() {
    const form = document.getElementById("paymentInfoForm");

    form.addEventListener("submit", function(event) {
        const cardNumber = document.getElementById("cardNumber").value;
        const cardHolder = document.getElementById("cardHolder").value;
        const expiryDate = document.getElementById("expiryDate").value;
        const cvv = document.getElementById("cvv").value;

        const cardNumberRegex = /^\d{16}$/;
        const cardHolderRegex = /^[a-zA-Z\s'-]+$/;
        const cvvRegex = /^\d{3,4}$/;
        const addressRegex = /^[a-zA-Z0-9\s,.'-]{3,}$/; // Regex per l'indirizzo


        let valid = true;
        let errorMessage = "";

        if (!cardNumberRegex.test(cardNumber)) {
            errorMessage += "Numero della carta non valido.\n";
            valid = false;
        }
        if (!cardHolderRegex.test(cardHolder)) {
            errorMessage += "Nome del titolare della carta non valido.\n";
            valid = false;
        }
        if (!isValidExpiryDate(expiryDate)) {
            errorMessage += "Data di scadenza non valida o nel passato.\n";
            valid = false;
        }
        if (!cvvRegex.test(cvv)) {
            errorMessage += "CVV non valido.\n";
            valid = false;
        }

        if (!valid) {
            alert(errorMessage);
            event.preventDefault(); // Impedisce l'invio del form
        }
    });

    function isValidExpiryDate(dateStr) {
        const [month, year] = dateStr.split('/');
        const lastDayOfMonth = new Date(year, month, 0);
        const today = new Date();
        today.setHours(0, 0, 0, 0); // Reset time to 00:00:00 for accurate comparison
        return lastDayOfMonth > today;
    }
});