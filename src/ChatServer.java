import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

//ChatServer class to manage connections from multiple clients.
//The server handles incoming connections, assigns a unique user ID to each connected client,
//and maintains a list of connected users.

public class ChatServer {
    private static final int PORT = 2427; // Port number for the server
    private static Set<ClientHandler> clientHandlers = ConcurrentHashMap.newKeySet(); // Set to maintain connected clients
    private static int userId = 0; // Counter to assign unique user IDs

 // Starts the chat server to accept incoming connections.
    public static void main(String[] args) {
        new ChatServer().startServer();
      
   
    }
    
    public void startServer() {
        System.out.println("Chat server started...");
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                Socket clientSocket = serverSocket.accept(); // Accept incoming client connection
                userId++;
                ClientHandler clientHandler = new ClientHandler(clientSocket, userId); 
                clientHandlers.add(clientHandler); // Add the client to the list of connected clients
                clientHandler.start(); // Start the client handler thread
            }
        } catch (IOException e) {
            System.out.println("Error starting the server: " + e.getMessage());
        }
    }
  
   //Broadcasts a message to all connected clients except the sender.
   //Here we have message to broadcast and user ID of the sender
    static void broadcastMessage(String message, int userId) {
        for (ClientHandler clientHandler : clientHandlers) {
            if (clientHandler.getUserId() != userId) {
                clientHandler.sendMessage("User " + userId + ": " + message);
            }
        }
    }

  //Removes a client from the list of connected clients    
    static void removeClient(ClientHandler clientHandler) {
        clientHandlers.remove(clientHandler);
        System.out.println("User " + clientHandler.getUserId() + " disconnected");
    }
  //ClientHandler class to handle communication with an individual client
private static class ClientHandler extends Thread {
        private Socket socket;
        private int userId;
        private PrintWriter out;

        public ClientHandler(Socket socket, int userId) {
            this.socket = socket;
            this.userId = userId;
        }

        @Override
        public void run() {
            try (
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true)
            ) {
                this.out = out;
                out.println("Welcome! You are User " + userId);
                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("User " + userId + ": " + message);
                    ChatServer.broadcastMessage(message, userId);
                }
            } catch (IOException e) {
                System.out.println("Error handling client: " + e.getMessage());
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    System.out.println("Error closing socket: " + e.getMessage());
                }
                ChatServer.removeClient(this);
            }
        }

        //Sends a message to the client
        //The message to send.
         
        public void sendMessage(String message) {
            if (out != null) {
                out.println(message);
            }
        }

        //Gets the user ID of the client.
         
        public int getUserId() {
            return userId; //return The user ID.
        }
    }
}


