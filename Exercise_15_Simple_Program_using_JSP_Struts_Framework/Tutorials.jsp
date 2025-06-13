<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Web Tutorials</title>
</head>
<body>
<div style="margin-left: 30%; margin-top: 10%; background-color: olive; height: 10%; width: 40%">
    <!-- Struts form to get language input -->
    <s:form action="finder" method="post">
        <s:textfield label="Enter your Language that you want to learn" key="language" />
        <s:submit align="center" />
    </s:form>
</div>
</body>
</html>
