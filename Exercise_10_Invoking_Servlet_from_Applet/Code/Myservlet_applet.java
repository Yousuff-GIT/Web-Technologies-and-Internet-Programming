import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Myservlet_applet extends HttpServlet {
    // Declare variables
    int count = 0;
    String content = new String();

    // Method to handle servlet requests sent by the applet
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        count++;
        try {
            // Input stream to read data sent from the applet
            DataInputStream servletinput = new DataInputStream(request.getInputStream());
            content = servletinput.readLine();
            servletinput.close();

            // Output stream back to the applet (not used for content in this case)
            DataOutputStream servletoutput = new DataOutputStream(response.getOutputStream());
            servletoutput.close();

            // Log servlet activity
            System.out.println("MyServlet_applet is Invoked...");
            System.out.println("Hello, the Received message is : " + content);
            System.out.println("Number of times the servlet invoked..." + count);
        } catch (Exception e) {
            System.out.println("Problem in Servlet Call");
            e.printStackTrace();
        }
    }
}
