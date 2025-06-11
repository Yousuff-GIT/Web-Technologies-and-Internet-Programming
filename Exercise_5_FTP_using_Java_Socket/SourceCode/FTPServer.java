// FTPServer.java
// This program creates a multi-threaded FTP server that listens on port 4444 and handles file transfers.
// The server accepts incoming client connections and delegates file transfer tasks to individual threads.

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class FTPServer {
    private static ServerSocket serverSocket;
    private static Socket clientSocket = null;

    public static void main(String[] args) throws IOException {
        try {
            // Initialize server socket on port 4444
            serverSocket = new ServerSocket(4444);
            System.out.println("Server started.");
        } catch (Exception e) {
            System.err.println("Port already in use.");
            System.exit(1);
        }

        // Continuously accept incoming connections
        while (true) {
            try {
                clientSocket = serverSocket.accept();
                System.out.println("Accepted connection : " + clientSocket);
                Thread t = new Thread(new ClientConnection(clientSocket));
                t.start();
            } catch (Exception e) {
                System.err.println("Error in connection attempt.");
            }
        }
    }
}
