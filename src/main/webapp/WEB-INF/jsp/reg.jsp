<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<!-- saved from url=(0032)http://localhost:8080/paamelding -->
<html lang="no"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="simple.css" rel="stylesheet" type="text/css">
    <!-- <script src="js/myscript.js" defer></script>  -->
    <title>Registration</title>
    <script src="js/script.js" defer></script>
    <style>
        .error {
            color: red;
            font-style: italic;
        }
    </style>
</head>

<body>
<h2>Registration</h2>


<form:form action="registration" method="post" modelAttribute="participant">
    <div>
        <form:label path="firstname">Firstname</form:label>
        <form:input  path="firstname" placeholder="First Name" onkeyup="checkFirstName()"/>
        <form:errors path="firstname" cssClass="error"/>
    </div>
    <div>
        <form:label path="lastname">Lastname</form:label>
        <form:input path="lastname" placeholder="Last Name" onkeyup="checkLastName()"/>
        <form:errors path="lastname" cssClass="error"/>
    </div>
    <div>
        <form:label path="mobile">Phone Number</form:label>
        <form:input path="mobile" placeholder="Phone Number" onkeyup="checkMobileNumber()"/>
        <form:errors path="mobile" cssClass="error"/>
    </div>
    <div>
        <form:label path="password">Password</form:label>
        <form:password path="password" placeholder="Password" onkeyup="checkPassword()"/>
        <form:errors path="password" cssClass="error"/>
    </div>
    <div>
        <label for="passwordRepeated">Confirm Password</label>
        <input id="passwordRepeated" name="passwordRepeated" placeholder="Re-Type Password" type="password" onkeyup="checkRepeatedPassword()">
    </div>
    <div>
        <form:label path="gender">Gender</form:label>
        <form:radiobutton path="gender" value="Man" />Man
        <form:radiobutton path="gender" value="Woman" />Woman
        <form:errors path="gender" cssClass="error"/>
    </div>
    <br><br><button type="submit">Sign me up</button>
</form:form>



</body></html>