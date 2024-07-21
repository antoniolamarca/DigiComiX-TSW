<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Registrazione - DigiComiX</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/PagineStile/Login.css">
</head>
<body>
<script> <%@include file="/script/Registervalidation.js"%> </script>
<main>
    <div id="foto-logo">
        <a href="Home.jsp"><img src="${pageContext.request.contextPath}/Immagini/Logo.png" alt="Logo" class="foto-registrazione"></a>
    </div>
    <h1>Registrati subito</h1>
    <div id="registrazione">
        <form method="POST" action="${pageContext.request.contextPath}/registerUser">
            <ul>
                <li>
                    <label for="nome">Nome:</label>
                    <input type="text" id="nome" name="nome" required>
                    <span id="nomeError" class="error"></span>
                </li>
                <li>
                    <label for="cognome">Cognome:</label>
                    <input type="text" id="cognome" name="cognome" required>
                    <span id="cognomeError" class="error"></span>
                </li>
                <li>
                    <label for="email">Email:</label>
                    <input type="email" id="email" name="email" required>
                    <span id="emailError" class="error"></span>
                </li>
                <li>
                    <label for="password">Password:</label>
                    <input type="password" id="password" name="password" required>
                    <span id="passwordError" class="error"></span>
                </li>
                <li>
                    <input type="submit" value="Registrati" id="btnReg" disabled>
                </li>
            </ul>
        </form>
    </div>
</main>
<%@include file="../Fragments/Footer.jsp" %>


</body>
</html>
