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

    <div id="login">
        <h1>Accedi</h1>
        <form method="post">
            <ul>
                <li>
                    <label for="username">Username:</label>
                    <input type="text" id="user_log" name="username" required>
                </li>
                <li>
                    <label for="password">Password:</label>
                    <input type="password" id="pass_log" name="password" required>
                </li>
                <li>
                    <input type="submit" value="Login">
                </li>
            </ul>
        </form>
    </div>
</body>
</html>
