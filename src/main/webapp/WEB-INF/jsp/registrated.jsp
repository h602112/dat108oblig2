<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!-- saved from url=(0030)http://localhost:8080/paameldt -->
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <link rel="stylesheet" href="simple.css">
    <title>Påmeldingsbekreftelse</title>
</head>
<body>
    <h2>Påmeldingsbekreftelse</h2>
    <p>Påmeldingen er mottatt for </p>
    <p>
        &nbsp;&nbsp;&nbsp;<c:out value="${participant.firstname}"/><br>
        &nbsp;&nbsp;&nbsp;Olsen<br>
        &nbsp;&nbsp;&nbsp;12345676<br> &nbsp;&nbsp;&nbsp;mann
    </p>
    <a href="http://localhost:8080/deltagerliste">Gå til deltagerlisten</a>
</body></html>