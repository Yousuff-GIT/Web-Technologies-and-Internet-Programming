<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head><title>Online Examination</title></head>
<body style="margin-top: 75px">
<% if (session.getAttribute("identification1") == null) { %>
<div align='center'><h1>Session Expired !</h1></div>
<% } else { session.setAttribute("identification2", session.getAttribute("identification1").toString()); %>
<form name="questions" method="post" action="evaluation">
<div align="center">
<h2>Answer all the following questions</h2>
<table width="65%" height="260" border="0">
<tr><td bgcolor="#CC9966">What is the abbreviation of W3C?</td>
<td bgcolor="#CC9966"><div align="center"><input type="text" name="ans1" /></div></td></tr>
<tr><td>Expand the acronym HTTP?</td>
<td><div align="center"><input type="text" name="ans2" /></div></td></tr>
<tr><td bgcolor="#CC9966">What is the protocol widely used for email transfer?</td>
<td bgcolor="#CC9966"><div align="center">
<input type="radio" name="protocol" value="http" />HTTP
<input type="radio" name="protocol" value="tcp/ip" />TCP/IP
<input type="radio" name="protocol" value="smtp" />SMTP
<input type="radio" name="protocol" value="ftp" />FTP
</div></td></tr>
<tr><td>Java Script is a Server Side Programming language</td>
<td><div align="center">
<input type="radio" name="js" value="true" />YES
<input type="radio" name="js" value="false" />NO
</div></td></tr>
<tr><td bgcolor="#CC9966">Which protocol is used to transfer the data packets?</td>
<td bgcolor="#CC9966"><div align="center"><input type="text" name="ans5" /></div></td></tr>
</table>
<p>&nbsp;</p>
<input type="submit" name="submit" value="Submit" />
</div>
</form>
<% } %>
</body>
</html>
