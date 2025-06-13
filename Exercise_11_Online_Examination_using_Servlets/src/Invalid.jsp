<html>
<head><title>Invalid Login</title></head>
<body style="margin-top: 50px">
<marquee><h2>Enter your credentials to take up the exam</h2></marquee>
<form name="form1" method="post" action="validation">
    <div align="center">
        <!-- Invalid login attempt icon -->
        <img src="Images/Unlock.png" width="256" height="256" />
        <h3>Invalid ID or Password!</h3>
        <h3>Student-ID <input name="stdid" type="text" /></h3>
        <h3>Password <input name="password" type="password" /></h3>
        <input name="Submit" type="submit" value="Login" />
        <input name="Reset" type="reset" value="Reset" />
    </div>
</form>
</body>
</html>
