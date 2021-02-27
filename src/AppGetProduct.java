// by Christian80gabi
// com.christian80gabi.api.socket

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Server Socket GetProduct (a single product)
 */
public class AppGetProduct {
    static int port = 5002;

    public static void main(String[] args) {
        try {
            // Creation of the Server Socket
            ServerSocket server = new ServerSocket(port);
            System.out.println("Running on port : " + port);

            // Accepting connection from a client
            Socket socket = server.accept();

            // Communication ways (Input & Output)
            // Output (write)
            OutputStream output = socket.getOutputStream(); // For writing values
            ObjectOutputStream objectOutput = new ObjectOutputStream(output); // For writing objects

            // Input (read)
            InputStream input = socket.getInputStream(); // For reading values
            // For reading larger values
            InputStreamReader reader = new InputStreamReader(input);
            BufferedReader bufferedReader = new BufferedReader(reader);
            // For reading objects
            // ObjectInputStream objectInput = new ObjectInputStream(input);

            // Services | Products services
            Services services = new Services();

            // Create a product
            Product product;

            // Get one product from the database by its reference and send it to the client

            String ref = bufferedReader.readLine(); // Get a String value (reference) from the client
            product =  services.getProduct(ref);

            objectOutput.writeObject(product); // Send the product found to the client

            // Closing the connection
            socket.close();
            server.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
