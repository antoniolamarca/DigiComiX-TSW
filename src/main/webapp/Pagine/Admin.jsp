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

  </div>
  </body>
</html>
