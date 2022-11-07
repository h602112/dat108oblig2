<!DOCTYPE html>
<!-- saved from url=(0032)http://localhost:8080/paamelding -->
<html lang="no"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="simple.css" rel="stylesheet" type="text/css">
    <!-- <script src="js/myscript.js" defer></script>  -->
    <title>Registration</title>
    <script src="js/script.js" defer></script>
</head>

<body>
<h2>Registration</h2>

<form id="participantFormBean" action="registration" method="post">
    <fieldset>

        <label for="firstname">firstname</label>
        <!-- NB! Spring sin (form:input)-tag støtter ikke required alene,
             men greit med required="noe"! -->
        <input id="firstname" name="firstname" title="..." pattern=".*" placeholder="fill out firstname" required="required" type="text" value="" onkeyup="checkFirstName()">

        <label for="lastname">lastname</label>
        <input id="lastname" name="lastname" title="..." pattern=".*" placeholder="fill out lastname" required="required" type="text" value="" onkeyup="checkLastName()">

        <label for="mobile">Mobile (8 numbers)</label>
        <input id="mobile" name="mobile" title="..." pattern=".*" placeholder="fill out phone number" required="required" type="text" value="" onkeyup="checkMobileNumber()">>

        <label for="password">Password</label>
        <input id="password" name="password" title="..." pattern=".*" placeholder="Choose a password" type="password" required="required" value="" onkeyup="checkPassword()">

        <label for="passwordRepeated">Password repeated</label>
        <input id="passwordRepeated" name="passwordRepeated" title="..." pattern=".*" placeholder="Repeat password" type="password" required="required" value="" onkeyup="checkRepeatedPassword()">

        <label for="gender">Gender:</label>
        <input id="gender1" name="gender" checked="checked" type="radio" value="man">man
        <input id="gender2" name="gender" type="radio" value="woman">woman

        <br><br><button type="submit">sign me up</button>
    </fieldset>
</form>


</body></html>