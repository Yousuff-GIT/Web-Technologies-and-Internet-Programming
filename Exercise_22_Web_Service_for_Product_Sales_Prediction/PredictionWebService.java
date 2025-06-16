// PredictionWebService.java
// Web service provider class for predicting product sales percentages.
// Developed using Java Web Services annotations with backend database integration.

package edu.cahcet.predictionservice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(serviceName = "PredictionWebService")
public class PredictionWebService {

    // Method to compute average sales percentage over past years
    @WebMethod(operationName = "salesPrediction")
    public String doPrediction(@WebParam(name = "product") String input) {
        Connection conn = null;
        Statement stmt;
        ResultSet rst;
        String WebServiceReply = null;

        int year10 = 0, year11 = 0, year12 = 0, year13 = 0, year14 = 0, year15 = 0, year16;

        try {
            // Load JDBC driver for MS Access database
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

            // Connect to the database
            conn = DriverManager.getConnection("jdbc:ucanaccess://E:/IPLab-DB/ProductSalesDB.accdb");

            // Create SQL statement and execute query
            stmt = conn.createStatement();
            rst = stmt.executeQuery("SELECT * FROM sales WHERE productname = '" + input + "'");

            // Retrieve past year sales data
            while (rst.next()) {
                year10 = rst.getInt("2010");
                year11 = rst.getInt("2011");
                year12 = rst.getInt("2012");
                year13 = rst.getInt("2013");
                year14 = rst.getInt("2014");
                year15 = rst.getInt("2015");
            }

            // Compute average for year 2016 prediction
            year16 = (year10 + year11 + year12 + year13 + year14 + year15) / 6;
            WebServiceReply = "" + year16 + "%";

            // Close connection
            conn.close();
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        return WebServiceReply;
    }
}