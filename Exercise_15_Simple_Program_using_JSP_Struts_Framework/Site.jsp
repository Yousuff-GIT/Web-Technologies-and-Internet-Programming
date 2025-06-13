<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tutorial Website</title>
</head>
<body>
<div style="margin-left: 30%; margin-top: 10%; height: 15%; width: 40%">
    <!-- Output the tutorial website using Struts properties -->
    <p>Name of the Tutorial WebSite
        <a href="https://<s:property value="tutorialsite"/>" target="_blank">
            <s:property value="tutorialsite" />
        </a>
    </p>
</div>
</body>
</html>
