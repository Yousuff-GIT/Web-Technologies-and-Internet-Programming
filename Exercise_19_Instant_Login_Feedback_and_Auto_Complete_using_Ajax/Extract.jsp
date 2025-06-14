<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*, javax.xml.parsers.*, org.w3c.dom.*, java.util.regex.*" %>
<html><head><title>Auto Complete</title></head><body>
<%
    // Redirect to form if input parameter is missing
    if(request.getParameter("placekey") == null) {
        %><jsp:forward page="Userform.jsp" /><%
    }

    String parameter = request.getParameter("placekey"); // Get input prefix
    String autobuffer = "<table>";

    try {
        // Load and parse the XML city list file
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder parser = factory.newDocumentBuilder();
        Document document = parser.parse("http://localhost:8080/AjaxForm/Xmlfolder/CityList.xml");

        NodeList nodes = document.getElementsByTagName("City");

        for (int i = 0; i < nodes.getLength(); i++) {
            String temp = nodes.item(i).getTextContent();
            String regex = parameter + ".*";
            Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(temp);

            // If city matches input pattern, show in suggestion list
            if (matcher.find()) {
                autobuffer += "<tr><td onclick='assignkey(this)'>" + temp + "</td></tr>";
            }
        }
    } catch (Exception e) {
        e.printStackTrace(); // Log exception
    }

    autobuffer += "</table>";
    response.getWriter().println(autobuffer); // Send back suggestion HTML
%>
</body></html>
