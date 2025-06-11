// POP3Demo.java
// This Java program demonstrates how to use the Post Office Protocol version 3 (POP3)
// to retrieve emails from a mail server using socket programming.

import java.io.*;
import java.net.*;

public class POP3Demo {
    // Input and output streams for socket communication
    DataInputStream dis;   // To receive server response
    PrintStream ps;        // To send POP3 commands
    Socket sock;           // Socket connection to POP3 server
    String hostName;       // Local host name
    String response, reply; // Strings to capture server responses

    public static void main(String args[]) {
        // Create object and initiate POP3 communication
        POP3Demo read = new POP3Demo();
        read.pop3communication();
    }

    // Method that handles the core logic of POP3 email retrieval
    private void pop3communication() {
        try {
            // Establish a socket connection to POP3 server at port 110
            sock = new Socket("localhost", 110);

            // Initialize input and output streams
            dis = new DataInputStream(sock.getInputStream());
            ps = new PrintStream(sock.getOutputStream());

            // Send USER command with email address
            ps.println("USER iplab@cahcetlab.edu.in");
            System.out.println(dis.readLine());  // Print server response

            // Send PASS command with password
            ps.println("PASS 123456");
            System.out.println(dis.readLine());

            // Send STAT command to retrieve number of messages and total size
            ps.println("STAT");
            System.out.println(dis.readLine());

            // Read the next line for message statistics
            response = dis.readLine();
            System.out.println(response);

            // Extract the message count from server response
            String mailnumber[] = response.split(" ");

            // Send RETR command to retrieve the first message
            ps.println("RETR " + mailnumber[1]);

            // Continuously read lines until '.' which marks the end of the message
            do {
                reply = dis.readLine();
                System.out.println(reply);
            } while (reply.charAt(0) != '.');

            // Send QUIT command to end the session
            ps.println("QUIT");
            System.out.println(dis.readLine());

            // Flush and close resources
            ps.flush();
            sock.close();
        } catch (Exception e) {
            System.out.println("Sorry unable to reach the Inbox");
            e.printStackTrace();
        }
    }
}
