<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<html><head><title>Check UserName</title></head><body>
<%
    // Check if 'uname' parameter is available
    if(request.getParameter("uname") == null) {
        %><jsp:forward page="Userform.jsp" /><%
    }

    String parameter = request.getParameter("uname"); // input username
    String buffer = "<span style='color:green;'>UserName is Available</span>"; // default message
    String temp = "";

    try {
        // Load UCanAccess driver and connect to MS Access DB
        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        Connection conn = DriverManager.getConnection("jdbc:ucanaccess://E:/IPLab-DB/PersonDetails.accdb");

        Statement st = conn.createStatement();
        ResultSet rst = st.executeQuery("SELECT username FROM person");

        // Compare input username with each existing username
        while(rst.next()) {
            temp = rst.getString("username");
            if(temp.equalsIgnoreCase(parameter))
                buffer = "<span style='color:red;'>UserName already taken</span>";
        }

        conn.close(); // Close connection
    } catch(Exception e) {
        e.printStackTrace(); // Print any DB exception
    }

    // Send response back to AJAX call
    response.getWriter().println(buffer);
%>
</body></html>
