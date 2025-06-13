<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Details</title>
</head>
<body>
<%session.setAttribute("SessionValue", "userform");%>
<div align="center">
<h2>Enter the following details</h2>
<form action="Save.jsp" method="post">
<table width="40%" cellpadding="5" >
<tr><td><label>Username</label></td>
<td>
<table>
<tr>
<td><input type="text" name="name" id="checkname" onblur="uservalidator()"></td>
<td><div id="checkstatus" style="font-size: small;"></div></td>
</tr>
</table>
</td>
</tr>
<tr><td><label>Password</label></td>
<td><input type="password" name="key"></td>
</tr>
<tr><td><label>Email-ID</label></td>
<td><input type="text" name="email"></td>
</tr>
<tr><td><label>Profession</label></td>
<td><input type="text" name="work"></td>
</tr>
<tr><td><label>Contact Number</label></td>
<td><input type="text" name="number"></td>
</tr>
<tr><td><label>City</label></td>
<td><input id="place" type="text" name="location" onkeypress="suggestion()">
<div id="placelist"></div>
</td>
</tr>
</table>
<br>
<input type="submit" value="Save">
</form>
</div>
<script type="text/javascript">
//Ajax function to check username availability
var xmlhttp;
function uservalidator() {
    var personname = document.getElementById("checkname").value;
    if (typeof XMLHttpRequest != "undefined")
        xmlHttp = new XMLHttpRequest();
    else if (window.ActiveXObject)
        xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
    if (xmlHttp == null) {
        alert("Browser does not support XMLHTTP Request");
        return;
    }
    if (personname == "")
        document.getElementById("checkstatus").innerHTML = "";
    else {
        var url = "Check.jsp?uname=" + personname;
        xmlHttp.onreadystatechange = stateChange;
        xmlHttp.open("GET", url, true);
        xmlHttp.send(null);
    }
}
function stateChange() {
    if (xmlHttp.readyState == 4 || xmlHttp.readyState == "complete") {
        document.getElementById("checkstatus").innerHTML = xmlHttp.responseText;
    }
}
</script>
<script type="text/javascript">
//Ajax function for auto complete suggestions
function suggestion() {
    var keyterm = document.getElementById("place").value;
    if (typeof XMLHttpRequest != "undefined")
        xmlHttp = new XMLHttpRequest();
    else if (window.ActiveXObject)
        xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
    if (xmlHttp == null) {
        alert("Browser does not support XMLHTTP Request");
        return;
    }
    if (keyterm == "")
        document.getElementById("placelist").innerHTML = "";
    else {
        var url = "Extract.jsp?placekey=" + keyterm;
        xmlHttp.onreadystatechange = stateChange2;
        xmlHttp.open("GET", url, true);
        xmlHttp.send(null);
    }
}
function stateChange2() {
    if (xmlHttp.readyState == 4 || xmlHttp.readyState == "complete") {
        document.getElementById("placelist").innerHTML = xmlHttp.responseText;
    }
}
function assignkey(key) {
    document.getElementById("placelist").innerHTML = "";
    document.getElementById("place").value = key.innerHTML;
}
</script>
</body>
</html>
