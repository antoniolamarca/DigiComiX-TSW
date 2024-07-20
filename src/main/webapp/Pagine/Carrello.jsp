<%@ page import="Model.Prodotto.ArticoloBean" %>
<%@ page import="Model.Carrello.Cart" %>
<!DOCTYPE html>
<html>
<head>
    <title>Carrello - DigiComiX</title>
    <link rel="stylesheet" type="text/css" href="../PagineStile/Carrello.css?version=1.4">
    <script src="${pageContext.request.contextPath}/script/Pagamento.js"></script>
    <script src="${pageContext.request.contextPath}/script/Payment.js"></script>
</head>
<body>
    <!-- header della pagina -->
    <%@include file="header.jsp" %>

    <h1>Il tuo carrello</h1>
    <div id="product-info">
        <table class="tabella-prodotti">
            <tr>
                <th><h3>Prodotti</h3></th>
                <th><h3>Prezzo</h3></th>
            </tr>
            <% if(request.getSession().getAttribute("cart")!= null){
                Cart prodotti = (Cart) request.getSession().getAttribute("cart");
                for(ArticoloBean o : prodotti.getCarrello()) {
                    %>
            <tr >
                <td ><img alt = "prodotto" src ="${pageContext.request.contextPath}/Immagini/Articoli/<%= o.getImages()%>" ></td >
                <td ><p > <%= o.getPrezzo()%> </p ></td >
            </tr >
                <% }
            }%>

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
            <form id="paymentInfoForm" action="${pageContext.request.contextPath}/EffettuaOrdine" method="post">
                <!-- Campi per le informazioni di pagamento-->
                <input type="text" class="campopagamento" id="cardNumber" name="cardNumber" placeholder="Numero Carta" required>
                <input type="text" class= "campopagamento" id="cardHolder" name="cardHolder" placeholder="Titolare Carta" required>
                <input type="month" class= "campopagamento" id="expiryDate" name="expiryDate" required>
                <input type="text" class= "campopagamento" id="cvv" name="cvv" placeholder="CVV" required>
                <input type="text" class= "campopagamento" id="address" name="address" placeholder="Indirizzo" required>
                <button id= "conferma" type="submit">Conferma Pagamento</button>
            </form>
        </div>
    </div>


    <!-- footer della pagina -->
    <%@include file="Footer.jsp"%>
</body>
</html>
