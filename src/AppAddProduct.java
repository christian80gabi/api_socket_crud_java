// by Christian80gabi
// com.christian80gabi.api.socket

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Server Socket AddProduct
 */
public class AppAddProduct {
    public static void main(String[] args) {
        try {
            // Creation of the Server Socket
            int port = 5001;
            ServerSocket server = new ServerSocket(port);
            System.out.println("Running on port : " + port);

            System.out.println("Waiting for an object from the client...");
            // Accepting connection from a client
            Socket socket = server.accept();

            // Communication ways (Input & Output)
            // Output (write)
            // OutputStream output = socket.getOutputStream(); // For writing values
            // Input (read)
            InputStream input = socket.getInputStream(); // For reading values
            ObjectInputStream objectInput = new ObjectInputStream(input); // For reading objects

            // Services | Products services
            Services services = new Services();

            // Create a product
            Product product;

            // receiving an Object from the client
            product = (Product) objectInput.readObject();
            System.out.println("The received product is:\n" + product);

            // Adding a product in the database
            if (product != null && product.getReference() != null) {
                services.addProduct(product);
            }

            // Closing the connection
            socket.close();
            server.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
