import java.util.Random;

//PortGenerator class to generate a random port number within a specified range
public class PortGenerator {
    public static void main(String[] args) {
        int minPort = 1024; // Minimum port number (exclusive) 
        int maxPort = 49151; // Maximum port number (inclusive)

        int randomPort = generateRandomPort(minPort, maxPort);
        System.out.println("Random port: " + randomPort);
    }

    // Generates a random port number within the specified range
    //
    public static int generateRandomPort(int minPort, int maxPort) {
        Random random = new Random(); //Return a random port number within the specified range
        return random.nextInt(maxPort - minPort) + minPort;
    }
}
