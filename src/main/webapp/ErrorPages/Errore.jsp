<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/PagineStile/Errore.css">
</head>
<body>
<div class="container">
    <h1>Oops! Si è verificato un errore.</h1>
    <p>Ci scusiamo per l'inconveniente. Si è verificato un errore imprevisto.</p>
    <img src="${pageContext.request.contextPath}/Immagini/Icone/Error.png" alt="Rimuovi" style="cursor:pointer"></td>

    <p><a href="<%=request.getContextPath()%>/Pagine/Home.jsp">Torna alla Homepage</a></p>
</div>
</body>
</html>
