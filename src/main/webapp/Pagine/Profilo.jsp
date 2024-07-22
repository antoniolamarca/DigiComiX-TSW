<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
  <title>Registrazione - DigiComiX</title>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/PagineStile/Profilo.css?=v1.5">
</head>
<body>
<div id="foto-logo">
  <a href="Home.jsp"><img src="${pageContext.request.contextPath}/Immagini/Logo.png" alt="Logo" class="foto-registrazione"></a>
</div>
<h1>Ciao ${sessionScope.nome}!</h1>
<div id="registrazione">
  <form method="POST" action="${pageContext.request.contextPath}/registerUser" id="dati"></form>
    <ul>
      <li>
        <label for="nome">Nome:</label>
        <input form="dati" type="text" id="nome" name="nome" required>
      </li>
      <li>
        <label for="cognome">Cognome:</label>
        <input form="dati" type="text" id="cognome" name="cognome" required>
      </li>
      <li>
        <label for="email">Email:</label>
        <input form="dati" type="email" id="email" name="email" required>
      </li>
      <li>
        <label for="password">Password:</label>
        <input form="dati" type="password" id="password" name="password" required>
      </li>
      <li>
        <input form="dati" type="submit" value="Aggiorna le tue credenziali" id="btnReg" disabled>
      </li>
      <li>
        <a href="${pageContext.request.contextPath}/Logout"><label for="btnLogout"></label><button  id="btnLogout">Logout</button> </a>

      </li>
    </ul>
    <script src="../script/Registervalidation.js"></script>

</div>
<%@include file="../Fragments/Footer.jsp" %>
</body>
</html>