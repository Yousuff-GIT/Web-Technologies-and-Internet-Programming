import java.applet.*;
import java.awt.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.URL;
import java.net.URLConnection;

public class MyApplet extends Applet {
    // Declaring the connection-related objects
    URL url = null;
    URLConnection servletConnection = null;

    // Message to be sent from applet to servlet
    String message = new String("Welcome to Applet - Servlet Communication");

    // The init() method initializes the applet and starts the servlet communication
    public void init() {
        try {
            // Connect to the servlet via HTTP
            url = new URL("http://localhost:8080/Exercise5b/Myservlet_applet");
            servletConnection = url.openConnection();

            // Enable both input and output
            servletConnection.setDoInput(true);
            servletConnection.setDoOutput(true);

            // Send message to servlet
            DataOutputStream appletoutput = new DataOutputStream(servletConnection.getOutputStream());
            appletoutput.writeBytes(message);
            appletoutput.flush();
            appletoutput.close();

            // Receive (but ignore) response from servlet
            DataInputStream appletinput = new DataInputStream(servletConnection.getInputStream());
            appletinput.close();
        } catch(Exception e) {
            System.out.println("Message is not sent due to some connection problem");
            e.printStackTrace();
        }
    }

    // The paint method displays applet interface text
    public void paint(Graphics g) {
        g.drawString("Applet - Servlet Communication", 400, 300);
        g.drawString("Applet is sending the message...", 400, 350);
    }
}
