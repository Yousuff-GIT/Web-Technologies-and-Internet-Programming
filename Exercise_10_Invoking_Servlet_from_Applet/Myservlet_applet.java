// Myservlet_applet.java
// This Java Servlet receives data from an applet and processes it.

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Myservlet_applet extends HttpServlet {
    // Variable to maintain invocation count
    int count = 0;
    String content = "";

    // The service() method processes both GET and POST requests
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        count++;
        try {
            // Input stream to read data sent by the applet
            DataInputStream servletinput = new DataInputStream(request.getInputStream());
            content = servletinput.readLine();
            servletinput.close();

            // Output stream to send acknowledgment to the applet
            DataOutputStream servletoutput = new DataOutputStream(response.getOutputStream());
            servletoutput.close();

            // Logging the received message and invocation status
            System.out.println("MyServlet_applet is Invoked...");
            System.out.println("Hello, the Received message is : " + content);
            System.out.println("Number of times the servlet invoked..." + count);
        } catch (Exception e) {
            System.out.println("Problem in Servlet Call");
            e.printStackTrace();
        }
    }
}
