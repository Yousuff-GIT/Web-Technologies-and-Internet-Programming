// DGChatClient.java
// This Java program implements the client side of a chat application using UDP protocol.

import java.io.*;
import java.net.*;

class DGChatClient {
    public static DatagramSocket clientsocket;
    public static DatagramPacket client_dp;
    public static BufferedReader client_reader;
    public static InetAddress client_ia;
    public static byte client_buffer[] = new byte[1024];

    // Define ports for communication
    public static int client_port = 8888, server_port = 9999;

    public static void main(String[] a) throws IOException {
        // Initialize the datagram socket to send data
        clientsocket = new DatagramSocket(client_port);
        client_dp = new DatagramPacket(client_buffer, client_buffer.length);
        client_reader = new BufferedReader(new InputStreamReader(System.in));
        client_ia = InetAddress.getLocalHost();

        System.out.println("Client is Running... Type 'STOP' to Quit");

        // Chat loop
        while (true) {
            // Read message to be sent from client console
            String send_message = new String(client_reader.readLine());

            // Convert message to bytes
            client_buffer = send_message.getBytes();

            // If message is STOP, exit loop and close socket
            if (send_message.equals("STOP")) {
                System.out.println("Terminated...");
                clientsocket.send(new DatagramPacket(client_buffer, send_message.length(), client_ia, server_port));
                break;
            }

            // Send message to server
            clientsocket.send(new DatagramPacket(client_buffer, send_message.length(), client_ia, server_port));

            // Wait to receive server response
            clientsocket.receive(client_dp);

            // Display server's response
            String receive_message = new String(client_dp.getData(), 0, client_dp.getLength());
            System.out.println("Server: " + receive_message);
        }
    }
}
