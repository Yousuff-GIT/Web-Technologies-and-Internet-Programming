// HttpRequest.java
// This Java program demonstrates how to send an HTTP request using low-level socket programming.
// It manually constructs the HTTP request and connects to a local server (e.g., Apache Tomcat).

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class HttpRequest {
    public static void main(String[] args) {
        try {
            // Initialize required variables
            String server_reply;
            String host = "localhost";         // Target host
            int port_number = 8080;            // HTTP port (default for Tomcat)

            // Get IP address and create a socket connection
            InetAddress ip_address = InetAddress.getByName(host);
            Socket socket = new Socket(ip_address, port_number);

            // Send HTTP GET request using PrintWriter
            PrintWriter writer = new PrintWriter(socket.getOutputStream());
            writer.print("GET /HTTPRequestDemo/welcome.html HTTP/1.1\r\n");
            writer.print("Host: localhost \r\n\r\n");
            writer.flush();

            // Read and display server response using BufferedReader
            BufferedReader buffer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while ((server_reply = buffer.readLine()) != null)
                System.out.println(server_reply);

            // Clean up and close connections
            writer.close();
            buffer.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
