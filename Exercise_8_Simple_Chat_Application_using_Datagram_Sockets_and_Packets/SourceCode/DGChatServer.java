// DGChatServer.java
// This Java program implements the server side of a simple chat application using UDP (DatagramSocket & DatagramPacket).

import java.io.*;
import java.net.*;

class DGChatServer {
    // Define socket and packet objects
    public static DatagramSocket serversocket;
    public static DatagramPacket server_dp;
    public static BufferedReader server_reader;
    public static InetAddress server_ia;
    public static byte server_buffer[] = new byte[1024];

    // Define ports for server and client
    public static int serverport = 8888, clientport = 9999;

    public static void main(String[] a) throws IOException {
        // Initialize datagram socket at client port (receives from client)
        serversocket = new DatagramSocket(clientport);

        // DatagramPacket to hold incoming data
        server_dp = new DatagramPacket(server_buffer, server_buffer.length);

        // Reader for console input to send messages back to client
        server_reader = new BufferedReader(new InputStreamReader(System.in));

        // Get IP address of local host
        server_ia = InetAddress.getLocalHost();

        System.out.println("Server is Running...");

        // Start chat loop
        while (true) {
            // Receive incoming datagram from client
            serversocket.receive(server_dp);

            // Convert byte data to string
            String receive_message = new String(server_dp.getData(), 0, server_dp.getLength());

            // If client sends STOP, terminate the session
            if (receive_message.equals("STOP")) {
                System.out.println("Terminated...");
                break;
            }

            // Print received message
            System.out.println("Client: " + receive_message);

            // Read response from server's console
            String send_message = new String(server_reader.readLine());

            // Convert response to bytes and send back to client
            server_buffer = send_message.getBytes();
            serversocket.send(new DatagramPacket(server_buffer, send_message.length(), server_ia, serverport));
        }
    }
}
