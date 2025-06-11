// FTPServer.java
// This program initiates an FTP server using ServerSocket and handles multiple clients via multithreading.

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class FTPServer {
    // ServerSocket to listen for client connections on a specific port
    private static ServerSocket serverSocket;
    private static Socket clientSocket = null;

    public static void main(String[] args) throws IOException {
        try {
            // Initialize server socket on port 4444
            serverSocket = new ServerSocket(4444);
            System.out.println("Server started.");
        } catch (Exception e) {
            // Port may already be in use
            System.err.println("Port already in use.");
            System.exit(1);
        }

        // Loop to accept client connections continuously
        while (true) {
            try {
                // Accept connection from client
                clientSocket = serverSocket.accept();
                System.out.println("Accepted connection : " + clientSocket);
                // Start a new thread to handle each client
                Thread t = new Thread(new ClientConnection(clientSocket));
                t.start();
            } catch (Exception e) {
                // Handle any connection errors
                System.err.println("Error in connection attempt.");
            }
        }
    }
}
