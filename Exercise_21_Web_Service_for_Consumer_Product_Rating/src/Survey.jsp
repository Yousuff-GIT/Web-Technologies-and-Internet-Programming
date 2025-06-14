<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<!DOCTYPE html>
<html><head><title>Survey</title></head><body>
<%
// Connect to DB and save ratings
Connection conn = null;
Statement stmt;
String name = null;
boolean flag = false;
int design = 0, performance = 0, battery = 0, support = 0, overall = 0;
try {
    name = request.getParameter("username");
    design = Integer.parseInt(request.getParameter("design"));
    performance = Integer.parseInt(request.getParameter("performance"));
    battery = Integer.parseInt(request.getParameter("battery"));
    support = Integer.parseInt(request.getParameter("support"));
    overall = (design + performance + battery + support) / 4;
} catch (Exception e) {
    out.println("<div align='center'><h3 style='color:red;'>Exception! Please enter valid inputs</h3></div>");
    e.printStackTrace(); flag = true;
}
if (!flag) {
    try {
        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        conn = DriverManager.getConnection("jdbc:ucanaccess://E:/IPLab-DB/SurveyDB.accdb");
        stmt = conn.createStatement();
        stmt.execute("INSERT INTO rating VALUES('" + name + "','" + design + "','" + performance + "','" + battery + "','" + support + "','" + overall + "')");
        out.println("<div align='center'><h2>Thank you! " + name + "</h2><h3 style='color:forestgreen;'>Successfully Saved!</h3></div>");
    } catch (Exception e) {
        out.println("<div align='center'><h3 style='color:red;'>Exception! Unable to Save your Reviews</h3></div>");
        e.printStackTrace();
    } finally {
        conn.close();
    }
}
%>
</body></html>