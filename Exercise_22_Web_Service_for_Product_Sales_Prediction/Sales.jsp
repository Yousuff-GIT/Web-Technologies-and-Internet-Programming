<!-- Sales.jsp -->
<!-- JSP client code to call the web service method and display sales prediction -->
<%@page import="edu.cahcet.webserviceclient.PredictionWebService_Service"%>
<%@page import="edu.cahcet.webserviceclient.PredictionWebService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Sales Prediction</title>
</head>
<body>
    <%
        // Receive the selected product from the form
        String productname = request.getParameter("laptop");

        // Create proxy object for web service
        PredictionWebService proxy = new PredictionWebService_Service().getPredictionWebServicePort();

        // Call the web service method to get the prediction
        String salespercentage = proxy.salesPrediction(productname);
    %>
    <div align="center" style="margin-left: 15%; margin-top: 10%; width: 70%; height: 10%; background-color: #dde1dd;">
        <h2>
            Predicted Sales Percentage for 
            <span style="color: blue"><%= productname %></span> 
            in the year 2016 is : 
            <span style="color: forestgreen"><%= salespercentage %></span>
        </h2>
    </div>
</body>
</html>