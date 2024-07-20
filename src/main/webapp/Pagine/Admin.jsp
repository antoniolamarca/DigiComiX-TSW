<%@ page import="Model.Prodotto.ArticoloBean" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Model.Utente.UtenteBean" %>
<%@ page import="Model.Ordine.OrdineBean" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
  <head>
    <title>Title</title>
  </head>
  <body>
  <div class="container">
      <h1>Gestione Prodotti</h1>

          <h2>Aggiungi un nuovo prodotto</h2>
          <form action="AggiungiProdotto" method="post">
              <label for="nome">Nome:</label>
              <input type="text" id="nome" name="nome" required>

              <label for="descrizione">Descrizione:</label>
              <input type="text" id="descrizione" name="descrizione" required>

              <label for="prezzo">Prezzo:</label>
              <input type="number" id="prezzo" name="prezzo" step="0.01" required>

              <label for="quantita">Quantità:</label>
              <input type="number" id="quantita" name="quantita" required>

              <button type="submit">Aggiungi Prodotto</button>
          </form>



          <h2>Elimina un prodotto</h2>
          <form action="EliminaProdotto" method="post">
              <label for="idProdotto">ID Prodotto:</label>
              <input type="number" id="idProdotto" name="idProdotto" required>

              <button type="submit">Elimina Prodotto</button>
          </form>

      <h2>Modifica un prodotto esistente</h2>
      <form action="ModificaProdotto" method="post">
          <label for="idProdottoModifica">ID Prodotto:</label>
          <input type="number" id="idProdottoModifica" name="idProdotto" required>

          <label for="nomeModifica">Nome:</label>
          <input type="text" id="nomeModifica" name="nome" required>

          <label for="descrizioneModifica">Descrizione:</label>
          <input type="text" id="descrizioneModifica" name="descrizione" required>

          <label for="prezzoModifica">Prezzo:</label>
          <input type="number" id="prezzoModifica" name="prezzo" step="0.01" required>

          <label for="quantitaModifica">Quantità:</label>
          <input type="number" id="quantitaModifica" name="quantita" required>

          <button type="submit">Modifica Prodotto</button>
      </form>

      <!-- Mostra tutti i prodotti -->
      <div class="section">
          <form action="${pageContext.request.contextPath}/PopolaAdmin" method="post" >
              <input type="submit" value="Popola tabelle:">
          </form>
          <h3>Lista dei prodotti</h3>

          <table>
              <tr>
                  <th>Nome</th>
                  <th>ID</th>
                  <th>Descrizione</th>
                  <th>Prezzo</th>
              </tr>
              <% if(request.getSession().getAttribute("listaArticoli") != null){
                  ArrayList<ArticoloBean> prodotti = (ArrayList<ArticoloBean>) request.getSession().getAttribute("listaArticoli");
                  for(ArticoloBean o : prodotti){
              %>
              <tr>
                  <td><%= o.getNome()%></td>
                  <td><%= o.getId()%></td>
                  <td><%= o.getDescrizione()%></td>
                  <td><%= o.getPrezzo()%></td>
              </tr>
              <%} }%>
          </table>
      </div>

      <!-- Mostra tutti gli utenti -->
      <div class="section">
          <h3>Lista degli utenti</h3>
          <table>
              <tr>
                  <th>Email</th>
                  <th>ID</th>
                  <th>Nome</th>
                  <th>Cognome</th>
              </tr>

              <% if(request.getSession().getAttribute("listaUtenti") != null){
                  ArrayList<UtenteBean> utenti = (ArrayList<UtenteBean>) request.getSession().getAttribute("listaUtenti");
                  for(UtenteBean o : utenti){
              %>
              <tr>
                  <td><%= o.getEmail()%></td>
                  <td><%= o.getId()%></td>
                  <td><%= o.getNome()%></td>
                  <td><%= o.getCognome()%></td>
              </tr>
              <%} }%>

          </table>
      </div>

      <!-- Mostra tutti gli ordini -->
      <div class="section">
          <h3>Lista degli Ordini</h3>
          <table>
              <tr>
                  <th>ID Ordine</th>
                  <th>ID Utente</th>
                  <th>Data di acquisto</th>
                  <th>Costo Totale</th>
              </tr>

              <% if(request.getSession().getAttribute("listaOrdini") != null){
                  ArrayList<OrdineBean> ordini = (ArrayList<OrdineBean>) request.getSession().getAttribute("listaOrdini");
                  for(OrdineBean o : ordini){
              %>
              <tr>
                  <td><%= o.getId()%></td>
                  <td><%= o.getId_utente()%></td>
                  <td><%= o.getData_ordine()%></td>
                  <td></td>
              </tr>
              <%} }%>

          </table>
      </div>


  </div>
  </body>
</html>
