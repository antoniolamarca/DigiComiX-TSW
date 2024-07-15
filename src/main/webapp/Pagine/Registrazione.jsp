<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Registrazione - DigiComiX</title>
    <link rel="stylesheet" type="text/css" href="../PagineStile/Login.css">
</head>
<body>
<%@include file="header.jsp" %>
    <h1>Registrati subito</h1>
    <div id="registrazione">
        <form method="POST" action="${pageContext.request.contextPath}/registerUser">
            <ul>
                <li>
                    <label for="nome">Nome:</label>
                    <input type="text" id="nome" name="nome" required placeholder="Nome">
                </li>
                <li>
                    <label for="cognome">Cognome:</label>
                    <input type="text" id="cognome" name="cognome" required>
                </li>
                <li>
                    <label for="email">Email:</label>
                    <input type="email" id="email" name="email" required placeholder="Es. abcd1234@gmail.com">
                </li>
                <li>
                    <label for="password">Password:</label>
                    <input type="password" id="password" name="password" required>
                </li>
                <li>
                    <input type="submit" value="Registrati" id="btnReg">
                </li>
            </ul>
        </form>
    </div>
    <%@include file="Footer.jsp" %>
</body>
</html>
