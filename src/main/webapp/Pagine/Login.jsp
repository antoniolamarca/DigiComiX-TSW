<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.time.LocalTime" %>
<html>
    <head>
        <title>Login - DigiComiX</title>
        <link rel="stylesheet" type="text/css" href="../PagineStile/Login.css?version=1.1">
    </head>
    <body>
        <%@include file="header.jsp" %>
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

        <div id="login">
            <h1>Accedi</h1>
            <form method="post">
                <ul>
                    <li>
                        <label for="email">Email:</label>
                        <input type="text" id="email" name="email" required>
                    </li>
                    <li>
                        <label for="password">Password:</label>
                        <input type="password" id="password" name="password" required>
                    </li>
                    <li>
                        <input type="submit" value="Login" id="btnLogin">
                    </li>
                </ul>
            </form>
            <p>Non sei registrato? <a href="Registrazione.jsp">Registrati qui</a></p>
        </div>

        <%@include file="Footer.jsp" %>
    </body>
</html>
