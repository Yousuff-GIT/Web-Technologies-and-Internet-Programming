<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!-- JSP form to collect user details and invoke AJAX -->
<html>
<head><title>User Details</title></head>
<body>
<%session.setAttribute("SessionValue", "userform");%>
<div align="center">
<h2>Enter the following details</h2>
<form action="Save.jsp" method="post">
<table width="40%" cellpadding="5">
<tr><td><label>Username</label></td>
<td><table><tr>
<td><input type="text" name="name" id="checkname" onblur="uservalidator()"></td>
<td><div id="checkstatus" style="font-size: small;"></div></td>
</tr></table></td></tr>
<tr><td><label>Password</label></td><td><input type="password" name="key"></td></tr>
<tr><td><label>Email-ID</label></td><td><input type="text" name="email"></td></tr>
<tr><td><label>Profession</label></td><td><input type="text" name="work"></td></tr>
<tr><td><label>Contact Number</label></td><td><input type="text" name="number"></td></tr>
<tr><td><label>City</label></td>
<td><input id="place" type="text" name="location" onkeypress="suggestion()"><div id="placelist"></div></td></tr>
</table><br><input type="submit" value="Save"></form></div>

<!-- AJAX Script for Username Validation -->
<script type="text/javascript">
function uservalidator() {
  var personname = document.getElementById("checkname").value;
  var xmlHttp = new XMLHttpRequest();
  if(personname === "") {
    document.getElementById("checkstatus").innerHTML = "";
    return;
  }
  var url="Check.jsp?uname=" + personname;
  xmlHttp.onreadystatechange = function() {
    if (xmlHttp.readyState==4 && xmlHttp.status==200)
      document.getElementById("checkstatus").innerHTML=xmlHttp.responseText;
  };
  xmlHttp.open("GET", url, true);
  xmlHttp.send(null);
}
</script>

<!-- AJAX Script for City Autocomplete -->
<script type="text/javascript">
function suggestion() {
  var keyterm = document.getElementById("place").value;
  var xmlHttp = new XMLHttpRequest();
  if(keyterm === "") {
    document.getElementById("placelist").innerHTML = "";
    return;
  }
  var url = "Extract.jsp?placekey=" + keyterm;
  xmlHttp.onreadystatechange = function() {
    if (xmlHttp.readyState==4 && xmlHttp.status==200)
      document.getElementById("placelist").innerHTML = xmlHttp.responseText;
  };
  xmlHttp.open("GET", url, true);
  xmlHttp.send(null);
}
function assignkey(key) {
  document.getElementById("placelist").innerHTML = "";
  document.getElementById("place").value = key.innerHTML;
}
</script>
</body></html>
