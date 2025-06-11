// ClientConnection.java
// This class handles individual client connections and facilitates file sending/receiving.

import java.io.*;
import java.net.Socket;

public class ClientConnection implements Runnable {
    private Socket clientSocket; // The socket through which server interacts with the client
    private BufferedReader in = null;

    public ClientConnection(Socket client) {
        this.clientSocket = client; // Assign client socket to local variable
    }

    public void run() {
        try {
            // Read client's choice (1 for send, 2 for receive)
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String clientSelection;
            while ((clientSelection = in.readLine()) != null) {
                switch (clientSelection) {
                    case "1":
                        // Client wants to send file
                        receiveFile();
                        break;
                    case "2":
                        // Client wants to receive file
                        String outGoingFileName;
                        while ((outGoingFileName = in.readLine()) != null) {
                            sendFile(outGoingFileName);
                        }
                        break;
                    default:
                        System.out.println("Incorrect command received.");
                        break;
                }
                in.close(); // Close the input stream
                break;
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    // Method to receive file from client
    public void receiveFile() {
        try {
            int bytesRead;
            DataInputStream clientData = new DataInputStream(clientSocket.getInputStream());

            // Read the name and size of the incoming file
            String fileName = clientData.readUTF();
            OutputStream output = new FileOutputStream("received_from_client_" + fileName);
            long size = clientData.readLong();

            // Buffer to hold file chunks
            byte[] buffer = new byte[1024];

            // Read file in chunks from socket
            while (size > 0 && (bytesRead = clientData.read(buffer, 0, (int)Math.min(buffer.length, size))) != -1) {
                output.write(buffer, 0, bytesRead);
                size -= bytesRead;
            }

            output.close();
            clientData.close();
            System.out.println("File " + fileName + " received from client.");
        } catch (IOException ex) {
            System.err.println("Client error. Connection closed.");
        }
    }

    // Method to send file to client
    public void sendFile(String fileName) {
        try {
            // Read file from local disk
            File myFile = new File(fileName);
            byte[] mybytearray = new byte[(int) myFile.length()];
            FileInputStream fis = new FileInputStream(myFile);
            BufferedInputStream bis = new BufferedInputStream(fis);
            DataInputStream dis = new DataInputStream(bis);
            dis.readFully(mybytearray, 0, mybytearray.length);

            // Write file to client socket
            OutputStream os = clientSocket.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);
            dos.writeUTF(myFile.getName());
            dos.writeLong(mybytearray.length);
            dos.write(mybytearray, 0, mybytearray.length);
            dos.flush();
            System.out.println("File " + fileName + " sent to client.");
        } catch (Exception e) {
            System.err.println("File does not exist!");
        }
    }
}
