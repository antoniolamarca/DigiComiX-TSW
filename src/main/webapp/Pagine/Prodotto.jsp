<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="Model.Prodotto.ArticoloBean" %>
<%@ page import="Model.Prodotto.ArticoloDao" %>
<%@ page import="java.sql.SQLException" %>

<%
    ArticoloBean articolo= (ArticoloBean) request.getSession().getAttribute("ArticoloTrovato");


%>
<html>
<head>
    <title>Prodotto - DigiComiX</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/PagineStile/Prodotto.css?version=1.2">
</head>
<body>
    <!-- header della pagina -->
    <%@ include file="../Fragments/header.jsp" %>

    <!-- visualizzazione del prodotto e degli altri elementi -->
    <div id="prodotto">

        <h1><%= articolo.getNome() %></h1>
        <table>
            <tr>
                <td><img src="${pageContext.request.contextPath}/Immagini/Articoli/<%= articolo.getImages() %>" alt="Immagine di <%= articolo.getNome() %>"></td>
                <td>
                    <div id="product-info">
                        <h3><%= articolo.getDescrizione() %></h3>
                        <br>
                        <div id="carrello" class="carrello-container">
                            <h3>Prezzo: €<%= articolo.getPrezzo() %></h3>
                            <center>
                                <form  onsubmit="event.preventDefault(); addProdottoCart(<%= articolo.getId() %>)">
                                <input type="submit" value="Aggiungi al carrello">
                                </form>
                            </center>
                        </div>
                    </div>
                </td>
            </tr>
       </table>

    </div>

    <script src="${pageContext.request.contextPath}/script/Ajax.js"></script>
    <div>
        <%@ include file="../Fragments/Footer.jsp" %>
    </div>
</body>
</html>