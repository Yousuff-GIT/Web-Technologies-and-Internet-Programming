// SMTPDemo.java
// This program demonstrates sending an email using the Simple Mail Transfer Protocol (SMTP)
// via a Java Socket connection to an SMTP server (like hMailServer running on localhost).

import java.io.*;
import java.net.*;

public class SMTPDemo {
    // Declare input and output streams for socket communication
    DataInputStream dis;  // To read server responses
    PrintStream ps;       // To send SMTP commands
    Socket sock;          // Socket for TCP connection
    String hostName;      // Stores the local host name

    // Main method serves as the program's entry point
    public static void main(String args[]) {
        SMTPDemo email = new SMTPDemo();  // Create object
        email.communication();            // Trigger communication method
    }

    // Method to handle SMTP communication over socket
    private void communication() {
        try {
            // Connect to SMTP server running on localhost port 25
            sock = new Socket("localhost", 25);

            // Initialize data streams for reading and writing
            dis = new DataInputStream(sock.getInputStream());
            ps = new PrintStream(sock.getOutputStream());

            // Get host name of local machine
            hostName = InetAddress.getLocalHost().getHostName();
            System.out.println("Host Name = " + hostName);

            // SMTP command: Introduce the client to the server
            ps.println("HELO " + hostName);
            System.out.println(dis.readLine());

            // SMTP command: Specify sender's email address
            ps.println("MAIL FROM: <admin@cahcetlab.edu.in>");
            System.out.println(dis.readLine());

            // SMTP command: Specify recipient's email address
            ps.println("RCPT TO: <iplab@cahcetlab.edu.in>");
            System.out.println(dis.readLine());

            // SMTP command: Start message body
            ps.println("DATA");
            System.out.println(dis.readLine());

            // SMTP email content
            ps.println("SUBJECT: Demonstration of SMTP"); // Subject line
            ps.println("Happy SMTP Programming with hmail server");  // Email body
            ps.println(".");  // SMTP end-of-data signal
            System.out.println(dis.readLine());

            // SMTP command: Close session
            ps.println("QUIT");
            System.out.println(dis.readLine());

            // Success message
            System.out.println("Delivery Status : SUCCESS");

            // Flush and close connections
            ps.flush();
            sock.close();
        } catch (Exception e) {
            System.out.println("Delivery Status : Failure");
            e.printStackTrace();
        }
    }
}
