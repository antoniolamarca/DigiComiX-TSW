<!DOCTYPE html>
<html>
<head>
    <title>Carrello - DigiComiX</title>
    <link rel="stylesheet" type="text/css" href="../PagineStile/Carrello.css?version=1.3">
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

    <!-- footer della pagina -->
    <%@include file="Footer.jsp"%>
</body>
</html>
