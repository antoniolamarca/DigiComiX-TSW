<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.time.LocalTime" %>
<html>
    <head>
        <title>Login - DigiComiX</title>
        <link rel="stylesheet" type="text/css" href="../PagineStile/Login.css?version=1.4">
        <script> <%@include file="/script/Loginvalidation.js"%> </script>
    </head>
    <body>
    <main>
        <div id="foto-logo">
            <a href="Home.jsp"><img src="../Immagini/Logo.png" alt="Logo" class="foto-login"></a>
        </div>
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
            <form method="post" action="${pageContext.request.contextPath}/LoginUser">
                <ul>
                    <li>
                        <label for="email">Email:</label>
                        <input type="text" id="email" name="email" required>
                        <div id="emailError" class="error"></div>
                    </li>
                    <li>
                        <label for="password">Password:</label>
                        <input type="password" id="password" name="password" required>
                        <div id="passwordError" class="error"></div>
                    </li>
                    <li>
                        <input type="submit" value="Login" id="btnLogin" disabled>
                    </li>
                </ul>
            </form>
            <script src="../script/Loginvalidation.js"></script>
            <p>Non sei registrato? <a href="Registrazione.jsp">Registrati qui</a></p>
        </div>
        </main>
        <%@include file="../Fragments/Footer.jsp" %>
    </body>
</html>
