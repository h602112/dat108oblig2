<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!-- saved from url=(0035)http://localhost:8080/deltagerliste -->
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <link rel="stylesheet" href="./simple.css">
    <title>Participantslist</title>
</head>
<body>
<p>Logged in as: ${user.mobile} / ${user.firstname} ${user.lastname}</p>
<h2>Participants list</h2>
<table>
    <tbody>
        <tr>
            <th>Gender</th>
            <th align="left">Name</th>
            <th align="left">Mobile</th>
        </tr>

        <c:forEach var="participant" items="${participants}">
            <tr style="${participant.mobile == user.mobile ? 'background-color: green' : null}">
                <td>
                    <c:choose>
                        <c:when test="${participant.gender == 'Man'}">&#9794;</c:when>
                        <c:otherwise>&#9792;</c:otherwise>
                    </c:choose>
                </td>
                <td>${participant.firstname} ${participant.lastname}</td>
                <td>${participant.mobile}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<br>
<form action="participantslist" method="post">
    <button type="submit">Log out</button>
</form>

</body></html>