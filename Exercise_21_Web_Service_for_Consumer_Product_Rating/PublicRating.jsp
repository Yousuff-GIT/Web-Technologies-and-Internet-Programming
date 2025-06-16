<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Product Rating</title>
</head>
<body>
<div align="center">
<h1>Hello! Welcome User</h1>
<!-- Form for collecting user reviews about the Samsung Galaxy Note -->
<form action="Survey.jsp" method="post">
<table width="50%" height="30%">
<caption>Please give your Reviews or Opinions for Survey</caption>
<hr>
<tr>
<td colspan="2">
<h3 align="center">Samsung Galaxy Note Reviews</h3>
</td>
</tr>
<!-- Input field to capture the name of the user -->
<tr>
<td colspan="2" align="center">
<label>Please enter your Name</label>
<input type="text" name="username"/>
</td>
</tr>
<!-- Radio buttons for Design rating -->
<tr>
<td><h4>Design</h4></td>
<td>
<fieldset>
<input type="radio" name="design" value="4"/>Best
<input type="radio" name="design" value="3"/>Better
<input type="radio" name="design" value="2"/>Good
<input type="radio" name="design" value="1"/>Poor
<input type="radio" name="design" value="0"/>Worst
</fieldset>
</td>
</tr>
<!-- Radio buttons for Performance rating -->
<tr>
<td><h4>Performance</h4></td>
<td>
<fieldset>
<input type="radio" name="performance" value="4"/>Best
<input type="radio" name="performance" value="3"/>Better
<input type="radio" name="performance" value="2"/>Good
<input type="radio" name="performance" value="1"/>Poor
<input type="radio" name="performance" value="0"/>Worst
</fieldset>
</td>
</tr>
<!-- Radio buttons for Battery rating -->
<tr>
<td><h4>Battery</h4></td>
<td>
<fieldset>
<input type="radio" name="battery" value="5"/>Best
<input type="radio" name="battery" value="3"/>Better
<input type="radio" name="battery" value="2"/>Good
<input type="radio" name="battery" value="1"/>Poor
<input type="radio" name="battery" value="0"/>Worst
</fieldset>
</td>
</tr>
<!-- Radio buttons for Application Support rating -->
<tr>
<td><h4>Application Support</h4></td>
<td>
<fieldset>
<input type="radio" name="support" value="4"/>Best
<input type="radio" name="support" value="3"/>Better
<input type="radio" name="support" value="2"/>Good
<input type="radio" name="support" value="1"/>Poor
<input type="radio" name="support" value="0"/>Worst
</fieldset>
</td>
</tr>
</table>
<br>
<input type="submit" value="Submit"/>
</form>
</div>
</body>
</html>
