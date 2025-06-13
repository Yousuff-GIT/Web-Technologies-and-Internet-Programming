<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import = "java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Searching</title>
</head>
<body>
<%
if(request.getParameter("searchterm") == null) {
%><jsp:forward page="Expired.jsp" /><%
}
String parameter = request.getParameter("searchterm");
String buffer = "";
String temp1 = "";
String temp2 = "";
String start = "<ol> ";
String end = "</ol>";
try {
    Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
    Connection conn = DriverManager.getConnection("jdbc:ucanaccess://E:/IPLabDB/Websites.accdb");
    Statement stmt = conn.createStatement();
    ResultSet rst = stmt.executeQuery("select * from sites where searchtext like '" + parameter + "%'");
    while (rst.next()) {
        temp1 = rst.getString("searchtext");
        temp2 = rst.getString("website");
        buffer = buffer + "<li> <a href='" + temp2 + "'> " + temp1 + " </a></li>";
    }
    conn.close();
} catch(Exception exception) {
    exception.printStackTrace();
}
buffer = start + buffer + end;
response.getWriter().println(buffer);
%>
</body>
</html>
