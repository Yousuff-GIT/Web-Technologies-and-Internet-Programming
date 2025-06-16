<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Survey</title>
</head>
<body>
<%
Connection conn = null;
Statement stmt;
String name = null;
boolean flag = false;
int design = 0, performance = 0, battery = 0, support = 0, overall = 0;

try {
    // Retrieve form inputs
    name = request.getParameter("username");
    design = Integer.parseInt(request.getParameter("design"));
    performance = Integer.parseInt(request.getParameter("performance"));
    battery = Integer.parseInt(request.getParameter("battery"));
    support = Integer.parseInt(request.getParameter("support"));

    // Compute the average rating
    overall = (design + performance + battery + support) / 4;
} catch (Exception e) {
%>
<div align="center">
<h3 style="color: red;">Exception!, Please enter valid inputs</h3>
</div>
<%
    e.printStackTrace();
    flag = true;
}

if (!flag) {
    try {
        // Load JDBC driver and establish connection to MS Access DB
        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        conn = DriverManager.getConnection("jdbc:ucanaccess://E:/IPLab-DB/SurveyDB.accdb");
        stmt = conn.createStatement();

        // Insert survey result into the database
        stmt.execute("INSERT INTO rating VALUES('" + name + "','" + design + "','" + performance + "','" + battery + "','" + support + "','" + overall + "')");
%>
<div align="center">
<h2>Thank you! <%=name%></h2>
<h3 style="color: forestgreen;">Successfully Saved!</h3>
</div>
<%
    } catch (Exception e) {
%>
<div align="center">
<h3 style="color: red;">Exception! Unable to Save your Reviews</h3>
</div>
<%
        e.printStackTrace();
    } finally {
        conn.close();
    }
}
%>
</body>
</html>
