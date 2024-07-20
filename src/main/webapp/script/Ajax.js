function addProdottoCart(id) {

    var body = new FormData;
    body.append("id", id);
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 200) {
            try {
                alert("Prodotto aggiunto al carrello")

            } catch (e) {
                console.error('Errore nel parsing della risposta JSON:', e);
                showNotification("Errore imprevisto");
            }
        } else if (this.readyState === 4) {
            showNotification("Errore nella richiesta al server");
        }
    };

    var url = getContextPath() + "/AggiungiACarrello";
    console.log('URL richiesta:', url);
    xhttp.open("POST", url, true);
    xhttp.send(body);
}



    function showNotification(message) {
        // Implementa la logica per mostrare la notifica all'utente
        alert(message);
    }

    function getContextPath() {
        var path = window.location.pathname;
        return path.substring(0, path.indexOf('/', 1));
    }

