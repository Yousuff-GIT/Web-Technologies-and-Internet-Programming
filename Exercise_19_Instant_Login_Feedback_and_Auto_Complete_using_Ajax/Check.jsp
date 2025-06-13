<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import = "java.sql.*" %>
<html><head><title>Check UserName</title></head><body>
<%
if(request.getParameter("uname") == null) {
    %><jsp:forward page="Userform.jsp" /><%
}
String parameter = request.getParameter("uname");
String buffer = "<span style='color:green;'>UserName is Available</span>";
String temp = "";
try {
    Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
    Connection conn = DriverManager.getConnection("jdbc:ucanaccess://E:/IPLab-DB/PersonDetails.accdb");
    Statement st = conn.createStatement();
    ResultSet rst = st.executeQuery("select username from person");
    while(rst.next()) {
        temp = rst.getString("username");
        if(temp.equalsIgnoreCase(parameter))
            buffer = "<span style='color:red;'>UserName already taken</span>";
    }
    conn.close();
} catch(Exception exception) {
    exception.printStackTrace();
}
response.getWriter().println(buffer);
%></body></html>
