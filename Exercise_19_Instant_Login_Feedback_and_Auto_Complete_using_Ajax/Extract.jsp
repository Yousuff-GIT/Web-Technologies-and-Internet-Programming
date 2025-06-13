<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*, javax.xml.parsers.*, org.w3c.dom.*, java.util.regex.*" %>
<html><head><title>Auto Complete</title></head><body>
<%
if(request.getParameter("placekey") == null) {
    %><jsp:forward page="Userform.jsp" /><%
}
String parameter = request.getParameter("placekey");
String autobuffer = "<table>";
try {
    DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder parser = docBuilderFactory.newDocumentBuilder();
    Document document = parser.parse("http://localhost:8080/AjaxForm/Xmlfolder/CityList.xml");
    NodeList nodes = document.getElementsByTagName("City");
    for (int i = 0; i < nodes.getLength(); i++) {
        String temp = nodes.item(i).getTextContent();
        String pat = parameter+".*";
        Pattern pattern = Pattern.compile(pat, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(temp);
        if (matcher.find()) {
            autobuffer += "<tr><td onclick='assignkey(this)'>"+temp+"</td></tr>";
        }
    }
} catch (Exception e) {
    e.printStackTrace();
}
autobuffer += "</table>";
response.getWriter().println(autobuffer);
%></body></html>
