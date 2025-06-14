<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import = "java.sql.*" %>
<html><head><title>Saving Details</title></head><body>
<%
    // Redirect if session is invalid
    if(session.getAttribute("SessionValue") == null) {
        %><jsp:forward page="Userform.jsp"/><%
    }

    // Collect form data
    String name = request.getParameter("name");
    String key = request.getParameter("key");
    String email = request.getParameter("email");
    String work = request.getParameter("work");
    String number = request.getParameter("number");
    String location = request.getParameter("location").trim();

    // Redirect if any field is empty
    if(name.isEmpty() || key.isEmpty() || email.isEmpty() || work.isEmpty() || number.isEmpty() || location.isEmpty()) {
        %><jsp:forward page="Userform.jsp"/><%
    }

    try {
        // Connect to MS Access database
        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        Connection conn = DriverManager.getConnection("jdbc:ucanaccess://E:/IPLab-DB/PersonDetails.accdb");

        Statement st = conn.createStatement();
        st.execute("INSERT INTO person VALUES ('" + name + "','" + key + "','" + email + "','" + work + "','" + number + "','" + location + "')");

        conn.close(); // Close connection
        %><jsp:forward page="Success.jsp"/><%
    } catch(Exception e) {
        e.printStackTrace(); // Show DB errors
        %><jsp:forward page="Exception.jsp"/><%
    }
%>
</body></html>
