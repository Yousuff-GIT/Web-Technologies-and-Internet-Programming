package edu.cahcet.javawebservice;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(serviceName = "SamsungReviews")
public class SamsungReviews {
    String values[] = {"Worst", "Poor", "Good", "Better", "Best"};

    @WebMethod(operationName = "mobilereviews")
    public String reviewService(@WebParam(name = "productname") String product) {
        Connection conn = null;
        Statement stmt;
        ResultSet rst;
        String WebServiceReply = null;
        int count = 0;
        int a = 0, b = 0, c = 0, d = 0, e = 0;

        if (product.equalsIgnoreCase("samsung galaxy note")) {
            try {
                // Load JDBC driver and connect to Access DB
                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                conn = DriverManager.getConnection("jdbc:ucanaccess://E:/IPLab-DB/SurveyDB.accdb");
                stmt = conn.createStatement();
                rst = stmt.executeQuery("select * from rating");

                // Aggregate rating values
                while (rst.next()) {
                    a += rst.getInt("design");
                    b += rst.getInt("performance");
                    c += rst.getInt("battery");
                    d += rst.getInt("support");
                    e += rst.getInt("overall");
                    count++;
                }

                // Compute average ratings
                a /= count; b /= count; c /= count; d /= count; e /= count;

                // Format web service reply
                WebServiceReply = "Design: " + values[a] + ", Performance: " + values[b] +
                                  ", Battery: " + values[c] + ", Application Support: " + values[d] +
                                  ", Overall Rating: " + values[e];

                conn.close();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        } else {
            WebServiceReply = "Sorry! Unknown Product";
        }

        return WebServiceReply;
    }
}
