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
    <%@ include file="header.jsp" %>

    <!-- visualizzazione del prodotto e degli altri elementi -->
    <div id="prodotto">

        <h1><%= articolo.getNome() %></h1>
        <table>
            <tr>
                <td><img src="${pageContext.request.contextPath}/Immagini/Articoli/<%= articolo.getImages() %>" alt="Immagine di <%= articolo.getNome() %>"></td>
                <td><div id="product-info"><h3><%= articolo.getDescrizione() %></h3>
                    <br>
                    <div id="carrello" class="carrello-container">
                        <h3>Prezzo: €<%= articolo.getPrezzo() %></h3>
                       <center> <form action="Carrello" method="post">
                            <input type="hidden" name="id" value="<%= articolo.getId() %>">
                            <input type="hidden" name="nome" value="<%= articolo.getNome() %>">
                            <input type="hidden" name="prezzo" value="<%= articolo.getPrezzo() %>">
                            <input type="submit" value="Aggiungi al carrello">
                        </form> </center>
                    </div>


                </div></td>
            </tr>
       </table>

    </div>


    <div>
        <%@ include file="Footer.jsp" %>
    </div>
</body>
</html>