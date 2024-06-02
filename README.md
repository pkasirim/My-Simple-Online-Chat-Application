# Simple-Online-Chat-Application
## Overview
This simple online chat application allows multiple users to connect to a central server, send messages, and receive messages from other users. It uses Java's socket programming for client-server communication.
## Features
- **Server**: Manages connections from multiple clients, assigns unique user IDs, and maintains a list of connected users.
- **Client**: Connects to the server, sends messages to the server, and receives broadcast messages from other users.
- **User Interface**: A simple text-based interface for message input and display.

## Requirements
- Java Development Kit (JDK) 8 or higher.

## How to Run

### Running the Server
1. Open a terminal/command prompt.
2. Navigate to the directory containing `ChatServer.java`.
3. Compile the `ChatServer` class:
   javac ChatServer.java
4. Run the ChatServer class:
   java ChatServer
### Implementation Details
# Server
- The ChatServer class listens on a specified port (default 2427) for incoming client connections.
- It assigns a unique user ID to each connected client and maintains a list of active client handlers.
- It broadcasts messages from any client to all other connected clients.
# Client
- The ChatClient class connects to the server using the specified host and port.
- It provides a simple text-based interface for the user to type and send messages.
- It runs a separate thread to listen for and display messages from the server.
# User Interface
- The user interface is text-based, using the console for input and output.
- Users can type their messages and press Enter to send them to the server.
- Messages from other users are displayed in the console.

## Error Handling
- Handles errors during client-server communication.
- Removes clients from the server list when they disconnect or encounter errors.
  
### Example from Screenshots of the Text-Based User Interface
Here are example screenshots of the text-based user interface for both the server and the client.
Congratulations! You're now Connected to the chat server.
*Type your messages below and Press Enter to send.
Hello
User 4: Hi! What's up?
Everything
User 7: Hello Java!
tell me more
User 1: 
I'm fine
User 1: 
User 8:*

README.MD FILE
https://github.com/pkasirim/Simple-Online-Chat-Application.git


# Simple-Online-Chat-Application
## Overview
This simple online chat application allows multiple users to connect to a central server, send messages, and receive messages from other users. It uses Java's socket programming for client-server communication.
## Features
- **Server**: Manages connections from multiple clients, assigns unique user IDs, and maintains a list of connected users.
- **Client**: Connects to the server, sends messages to the server, and receives broadcast messages from other users.
- **User Interface**: A simple text-based interface for message input and display.

## Requirements
- Java Development Kit (JDK) 8 or higher.

## How to Run

### Running the Server
1. Open a terminal/command prompt.
2. Navigate to the directory containing `ChatServer.java`.
3. Compile the `ChatServer` class:
   javac ChatServer.java
4. Run the ChatServer class:
   java ChatServer
### Implementation Details
# Server
- The ChatServer class listens on a specified port (default 2427) for incoming client connections.
- It assigns a unique user ID to each connected client and maintains a list of active client handlers.
- It broadcasts messages from any client to all other connected clients.
# Client
- The ChatClient class connects to the server using the specified host and port.
- It provides a simple text-based interface for the user to type and send messages.
- It runs a separate thread to listen for and display messages from the server.
# User Interface
- The user interface is text-based, using the console for input and output.
- Users can type their messages and press Enter to send them to the server.
- Messages from other users are displayed in the console.

## Error Handling
- Handles errors during client-server communication.
- Removes clients from the server list when they disconnect or encounter errors.
  
### Example from Screenshots of the Text-Based User Interface
Here are example screenshots of the text-based user interface for both the server and the client.
Congratulations! You're now Connected to the chat server.
*Type your messages below and Press Enter to send.
Hello
User 4: Hi! What's up?
Everything
User 7: Hello Java!
tell me more
User 1: 
I'm fine
User 1: 
User 8:*

**This implementation ensures that the chat application is usable, with a straightforward and intuitive text-based user interface for sending and receiving messages. The provided screenshots illustrate the expected output in the console when running the server and client applications.**

### References 
- [GeeksforGeeks: How to Implement a Simple Chat Application Using Sockets in Java](https://www.geeksforgeeks.org/simple-chat-application-using-sockets-in-java/)
- [GitHub: Simple-Chat-Project](https://github.com/RichDaly/Simple_Chat_Project)
- [GitHub: Simple-Chat-Project](https://github.com/RichDaly/Simple_Chat_Project)
- [Java Socket Programming - GeeksforGeeks](https://www.geeksforgeeks.org/socket-programming-in-java/)
- [Java Networking - Oracle Documentation](https://docs.oracle.com/javase/tutorial/networking/sockets/)

