<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<!-- saved from url=(0032)http://localhost:8080/paamelding -->
<html lang="no"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="simple.css" rel="stylesheet" type="text/css">
    <!-- <script src="js/myscript.js" defer></script>  -->
    <title>Registration</title>
    <!--<script src="js/script.js" defer></script>-->
</head>

<body>
<h2>Registration</h2>
<form:form action="registration" method="post" modelAttribute="participant">
    <fieldset>

        <label class="required" for="firstname">Firstname</label>
        <input id="firstname" name="firstname" title="..." pattern=".*" placeholder="First Name" type="text" value="" onkeyup="checkFirstName()">
        <form:errors path="firstname" cssClass="error"></form:errors>
        <label class="required" for="lastname">Lastname</label>
        <input id="lastname" name="lastname" title="..." pattern=".*" placeholder="Last Name" type="text" value="" onkeyup="checkLastName()">

        <label class="required" for="mobile">Phone Number</label>
        <input id="mobile" name="mobile" title="..." pattern=".*" placeholder="Phone Number" type="number" value="" onkeyup="checkMobileNumber()">

        <label class="required" for="password">Password</label>
        <input id="password" name="password" title="..." pattern=".*" placeholder="Password" type="password" value="" onkeyup="checkPassword()">

        <label class="required" for="passwordRepeated">Confirm Password</label>
        <input id="passwordRepeated" name="passwordRepeated" title="..." pattern=".*" placeholder="Re-Type Password" type="password" value="" onkeyup="checkRepeatedPassword()">

        <label class="required" for="gender">Gender:</label>
        <input id="gender1" name="gender" checked="checked" type="radio" value="Man">Man
        <input id="gender2" name="gender" type="radio" value="Woman">Woman

        <br><br><button type="submit">Sign me up</button>
    </fieldset>
</form:form>


</body></html>