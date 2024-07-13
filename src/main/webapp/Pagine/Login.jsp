<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.time.LocalTime" %>
<html>
<head>
    <title>Login - DigiComiX</title>
    <link rel="stylesheet" type="text/css" href="../PagineStile/Login.css">
</head>
<body>
    <%
        LocalTime now = LocalTime.now();
        String message;

        if(now.isBefore(LocalTime.of(12, 0))) {
            message = "Buongiorno! ";
        } else if(now.isBefore(LocalTime.of(18, 0))) {
            message = "Buon pomeriggio!";
        } else {
            message = "Buonasera!";
        }
    %>
    <h1><%= message %></h1>

    <div id="azioni">
        <div id="registrazione">
            <form action="reg" method="post">
                <h1>Registrati subito</h1>
                <label for="nome">Nome:</label>
                <input type="text" id="nome" name="nome" required>

                <label for="cognome">Cognome:</label>
                <input type="text" id="cognome" name="cognome" required >

                <label for="username">Username:</label>
                <input type="text" id="username" name="username" required>

                <label for="email">Email:</label>
                <input type="email" id="email" name="email" required placeholder="Es. abcd1234@gmail.com">

                <label for="password">Password:</label>
                <input type="password" id="password" name="password" required>

                <input type="submit" value="Registrati">
            </form>
        </div>
        <div id="login">
            <h1>Accedi</h1>
            <form action="login" method="post">
                <label for="username">Username:</label>
                <input type="text" id="user_log" name="username" required>

                <label for="password">Password:</label>
                <input type="password" id="pass_log" name="password" required>

                <input type="submit" value="Login">
            </form>
        </div>
    </div>
    <%@include file="Footer.jsp" %>
</body>
</html>
