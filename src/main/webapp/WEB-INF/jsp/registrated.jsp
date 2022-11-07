<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!-- saved from url=(0030)http://localhost:8080/paameldt -->
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <link rel="stylesheet" href="simple.css">
    <title>Registration confirmation</title>
</head>
<body>
    <h2>Registration confirmation</h2>
    <p>Registration received for</p>
    <p>
        &nbsp;&nbsp;&nbsp;<c:out value="${participant.firstname}"/><br>
        &nbsp;&nbsp;&nbsp;<c:out value="${participant.lastname}"/><br>
        &nbsp;&nbsp;&nbsp;<c:out value="${participant.mobile}"/><br>
        &nbsp;&nbsp;&nbsp;<c:out value="${participant.gender}"/>
    </p>
    <a href="http://localhost:8080/deltagerliste">Go to participants list</a>
</body></html>