// FTPServer.java
// This program starts a basic FTP server using Java Socket programming.
// It continuously listens for incoming client connections and spawns a thread for each.

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class FTPServer {
    private static ServerSocket serverSocket; // Server socket for listening on a specific port
    private static Socket clientSocket = null; // Socket to handle client connection

    public static void main(String[] args) throws IOException {
        try {
            // Initialize the server to listen on port 4444
            serverSocket = new ServerSocket(4444);
            System.out.println("Server started.");
        } catch (Exception e) {
            // If port is already in use, display error and exit
            System.err.println("Port already in use.");
            System.exit(1);
        }

        // Loop to keep server running and accepting connections
        while (true) {
            try {
                // Accept incoming client connection
                clientSocket = serverSocket.accept();
                System.out.println("Accepted connection : " + clientSocket);

                // Create a new thread to handle each client separately
                Thread t = new Thread(new ClientConnection(clientSocket));
                t.start();
            } catch (Exception e) {
                System.err.println("Error in connection attempt.");
            }
        }
    }
}
