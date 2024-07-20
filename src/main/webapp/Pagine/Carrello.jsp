<!DOCTYPE html>
<html>
<head>
    <title>Carrello - DigiComiX</title>
    <link rel="stylesheet" type="text/css" href="../PagineStile/Carrello.css?version=1.4">
    <script src="${pageContext.request.contextPath}/script/Pagamento.js"></script>
</head>
<body>
    <!-- header della pagina -->
    <%@include file="header.jsp" %>

    <h1>Il tuo carrello</h1>
<form action="Carrello" method="post">
    <div id="product-info">
        <table class="tabella-prodotti">
            <tr>
                <th><h3>Prodotti</h3></th>
                <th><h3>Prezzo</h3></th>
            </tr>
            <tr>
                <td><img alt="prodotto" src="../Immagini/Articoli/1.jpg"></td>
                <td><p>5,99 euro</p></td>
            </tr>
            <tr>
                <td><img alt="prodotto" src="../Immagini/Articoli/BoxMagic.png"></td>
                <td><p>9,99 euro</p></td>
            </tr>
            <tr>
                <td><img alt="prodotto" src="../Immagini/Articoli/DarlingXX.jpg"></td>
                <td><p>5,99 euro</p></td>
            </tr>
        </table>
        <table>
            <tr>
                <th>Totale</th>
            </tr>
            <tr>
                <td>21,97 euro</td>
            </tr>
        </table>
        
        <button type="submit" name="action" value="checkout" class="bottone_checkout">Procedi all'acquisto</button>
    </div>
    <!-- Div per il menu di pagamento in sovraimpressione -->
    <div id="payment-overlay" style="display:none;">
        <div id="payment-form">
            <div id="chiudiFinestra">
                <button id="closePaymentForm">X</button>
            </div>
            <h2>Informazioni di Pagamento</h2>
            <form id="paymentInfoForm" action="/path/to/payment/processing" method="post">
                <!-- Campi per le informazioni di pagamento-->
                <input type="text" class="campopagamento" id="cardNumber" name="cardNumber" placeholder="Numero Carta" required>
                <input type="text" class= "campopagamento" id="cardHolder" name="cardHolder" placeholder="Titolare Carta" required>
                <input type="month" class= "campopagamento" id="expiryDate" name="expiryDate" required>
                <input type="text" class= "campopagamento" id="cvv" name="cvv" placeholder="CVV" required>
                <button id= "conferma" type="submit">Conferma Pagamento</button>
            </form>
        </div>
    </div>

    <!-- footer della pagina -->
    <%@include file="Footer.jsp"%>
</body>
</html>
