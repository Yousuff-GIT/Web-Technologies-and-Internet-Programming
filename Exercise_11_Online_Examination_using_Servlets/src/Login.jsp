<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>
<body style="margin-top: 50px">
<marquee>
    <h2>Enter your credentials to take up the exam</h2>
</marquee>
<form name="Loginform" method="post" action="validation">
    <div align="center">
        <!-- Student Login Icon -->
        <img src="Images/Unlock.png" width="256" height="256" />
        <!-- Input fields for Student ID and Password -->
        <h3>Student-ID <input name="stdid" type="text" /></h3>
        <h3>Password <input name="password" type="password" /></h3>
        <!-- Login and Reset Buttons -->
        <input name="Submit1" type="submit" value="Login" />
        <input name="Submit2" type="reset" value="Reset" />
    </div>
</form>
</body>
</html>
