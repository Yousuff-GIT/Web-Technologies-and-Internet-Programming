// FTPClient.java
// This program connects to an FTP server and allows sending or receiving files using socket streams.

import java.io.*;
import java.net.Socket;

public class FTPClient {
    private static Socket sock; // Socket to connect to server
    private static String fileName; // File name entered by user
    private static BufferedReader stdin; // To read user input
    private static PrintStream os; // Output stream to send commands

    public static void main(String[] args) throws IOException {
        try {
            // Connect to the FTP server running on localhost at port 4444
            sock = new Socket("localhost", 4444);
            stdin = new BufferedReader(new InputStreamReader(System.in));
        } catch (Exception e) {
            System.err.println("Cannot connect to the server, try again later.");
            System.exit(1);
        }

        os = new PrintStream(sock.getOutputStream());

        try {
            switch (Integer.parseInt(selectAction())) {
                case 1:
                    // Option 1: send file
                    os.println("1");
                    sendFile();
                    break;
                case 2:
                    // Option 2: receive file
                    os.println("2");
                    System.err.print("Enter file name: ");
                    fileName = stdin.readLine();
                    os.println(fileName);
                    receiveFile(fileName);
                    break;
            }
        } catch (Exception e) {
            System.err.println("Not valid input");
        }

        sock.close(); // Close socket connection
    }

    // Method to display menu and get user input
    public static String selectAction() throws IOException {
        System.out.println("1. Send file.");
        System.out.println("2. Receive file.");
        System.out.print("\nMake selection: ");
        return stdin.readLine();
    }

    // Method to send file to server
    public static void sendFile() {
        try {
            System.err.print("Enter file name: ");
            fileName = stdin.readLine();
            File myFile = new File(fileName);
            byte[] mybytearray = new byte[(int) myFile.length()];

            FileInputStream fis = new FileInputStream(myFile);
            BufferedInputStream bis = new BufferedInputStream(fis);
            DataInputStream dis = new DataInputStream(bis);
            dis.readFully(mybytearray, 0, mybytearray.length);

            OutputStream os = sock.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);
            dos.writeUTF(myFile.getName());
            dos.writeLong(mybytearray.length);
            dos.write(mybytearray, 0, mybytearray.length);
            dos.flush();
            System.out.println("File " + fileName + " sent to Server.");
        } catch (Exception e) {
            System.err.println("File does not exist!");
        }
    }

    // Method to receive file from server
    public static void receiveFile(String fileName) {
        try {
            int bytesRead;
            InputStream in = sock.getInputStream();
            DataInputStream clientData = new DataInputStream(in);

            fileName = clientData.readUTF(); // Read file name
            OutputStream output = new FileOutputStream("received_from_server_" + fileName);
            long size = clientData.readLong(); // Read file size

            byte[] buffer = new byte[1024];
            while (size > 0 && (bytesRead = clientData.read(buffer, 0, (int)Math.min(buffer.length, size))) != -1) {
                output.write(buffer, 0, bytesRead);
                size -= bytesRead;
            }

            output.close();
            in.close();
            System.out.println("File " + fileName + " received from Server.");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
