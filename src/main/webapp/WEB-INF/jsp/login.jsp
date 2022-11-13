<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<!-- saved from url=(0032)http://localhost:8080/innlogging -->
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <link rel="stylesheet" href="simple.css">
    <title>Logg inn</title>
</head>
<body>
<h2>Logg inn</h2>
<p style="color:red;">${redirectMessage}</p>

<form action="login" method="post">
    <fieldset>
        <label for="mobile">Phone Number:</label> <input type="text" id="mobile" name="mobile" placeholder="Phone Number" required>
        <label for="password">Password:</label> <input type="password" id="password" name="password" placeholder="Password" required>
        <br><br><button type="submit">Login</button>
    </fieldset>
</form>


</body></html>