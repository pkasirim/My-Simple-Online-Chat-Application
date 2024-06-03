import java.io.*;
import java.net.*;

 //ChatClient class handles connecting to the chat server,
 //sendingssages to the server, and receiving messages from the server.

public class ChatClient {
    // Host address of the server
    private static final String SERVER_HOST = "localhost";
    // Port number of the server
    private static final int SERVER_PORT = 2427;

    public static void main(String[] args) {
        // Create a new ChatClient instance and start the client
        new ChatClient().startClient();
    }

    //Method to start the chat client.
     //It connects to the server, sets up input/output streams, and handles message sending and receiving.
    
    public void startClient() {
        try (
            // Establish a socket connection to the server
            Socket socket = new Socket(SERVER_HOST, SERVER_PORT);
            // Reader to get input from the user
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            // Writer to send messages to the server
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))
        ) {
            // Inform the user that they are connected to the server
            System.out.println("Congratulations! You're now Connected to the chat server.");
            System.out.println("Type your messages below and Press Enter to send.");

            // Start a separate thread to receive messages from the server
            Thread receiverThread = new Thread(() -> {
                try {
                    String serverMessage;
                    // Continuously read messages from the server and print them
                    while ((serverMessage = in.readLine()) != null) {
                        System.out.println(serverMessage);
                    }
                } catch (IOException e) {
                    System.out.println("Error reading message from server: " + e.getMessage());
                }
            });

            // Start the receiver thread
            receiverThread.start();

            // Main thread to read user input and send it to the server
            String userInputLine;
            while ((userInputLine = userInput.readLine()) != null) {
                out.println(userInputLine);
            }
        } catch (IOException e) {
            System.out.println("Error connecting to the chat server: " + e.getMessage());
        }
    }
}

