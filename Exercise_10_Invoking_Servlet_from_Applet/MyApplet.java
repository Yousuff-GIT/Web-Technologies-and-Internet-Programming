// MyApplet.java
// This Java Applet demonstrates communication with a servlet.

import java.applet.*;
import java.awt.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.URL;
import java.net.URLConnection;

public class MyApplet extends Applet {
    // URL object for establishing a connection with the servlet
    URL url = null;
    // URLConnection object to open communication with servlet
    URLConnection servletConnection = null;

    // Message to be sent to the servlet
    String message = "Welcome to Applet - Servlet Communication";

    // init() method initializes the Applet and sends message to the servlet
    public void init() {
        try {
            // Creating a connection to the servlet
            url = new URL("http://localhost:8080/Exercise5b/Myservlet_applet");
            servletConnection = url.openConnection();

            // Enabling input/output for message transfer
            servletConnection.setDoInput(true);
            servletConnection.setDoOutput(true);

            // Sending message using output stream
            DataOutputStream appletoutput = new DataOutputStream(servletConnection.getOutputStream());
            appletoutput.writeBytes(message);
            appletoutput.flush();
            appletoutput.close();

            // Reading response from the servlet
            DataInputStream appletinput = new DataInputStream(servletConnection.getInputStream());
            appletinput.close();
        } catch(Exception e) {
            System.out.println("Message is not sent due to some connection problem");
            e.printStackTrace();
        }
    }

    // paint() method to display the applet UI
    public void paint(Graphics g) {
        g.drawString("Applet - Servlet Communication", 400, 300);
        g.drawString("Applet is sending the message...", 400, 350);
    }
}
