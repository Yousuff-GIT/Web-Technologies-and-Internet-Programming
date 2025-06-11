<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.File" %>
<%@ page import="javax.xml.parsers.DocumentBuilderFactory" %>
<%@ page import="javax.xml.parsers.DocumentBuilder" %>
<%@ page import="org.w3c.dom.Document" %>
<%@ page import="org.w3c.dom.NodeList" %>
<%@ page import="org.w3c.dom.Node" %>

<!--
  This JSP script retrieves a roll number from the request and parses an XML document
  using DOM parser to display corresponding student information.
-->
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Student Profile</title>
</head>
<body>
<%
    // Get the input roll number from the previous form
    String rollnumber = request.getParameter("rollnumber");

    try {
        // Initialize DocumentBuilderFactory for XML DOM parsing
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Load XML document from server directory
        Document doc = builder.parse("http://localhost:8080/XMLReaderApp/XMLDirectory/StudentsData.xml");

        // Retrieve all roll numbers from the XML
        NodeList rollNodes = doc.getElementsByTagName("Rollno");

%>
    <div align="center">
        <table width="50%" cellspacing="3" border="1" cellpadding="5">
            <tr align="center">
                <td colspan="2"><h2>Student Details</h2></td>
            </tr>
<%
        boolean found = false;
        for (int i = 0; i < rollNodes.getLength(); i++) {
            String currentRoll = rollNodes.item(i).getTextContent();
            if (currentRoll.equals(rollnumber)) {
                found = true;
                Node parent = rollNodes.item(i).getParentNode();
                NodeList children = parent.getChildNodes();
                for (int j = 0; j < children.getLength(); j++) {
                    if (children.item(j).getNodeType() == Node.ELEMENT_NODE) {
%>
            <!-- Display each XML tag and corresponding value -->
            <tr bgcolor="#FFCD99">
                <td><%= children.item(j).getNodeName() %></td>
                <td><%= children.item(j).getTextContent() %></td>
            </tr>
<%
                    }
                }
                break;
            }
        }
        if (!found) {
%>
            <tr>
                <td colspan="2"><h3>Invalid Student Roll Number!</h3></td>
            </tr>
<%
        }
    } catch (Exception e) {
        e.printStackTrace();
%>
        <tr><td colspan="2">Error parsing XML file.</td></tr>
<%
    }
%>
        </table>
    </div>
</body>
</html>
