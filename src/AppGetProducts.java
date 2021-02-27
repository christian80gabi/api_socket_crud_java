// by Christian80gabi
// com.christian80gabi.api.socket

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

/**
 * Server Socket GetProducts (List of products)
 */
public class AppGetProducts {
    static int port = 5003;

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

            // Services | Products services
            Services services = new Services();

            // Get all products from the database and send them to the client
            List<Product> products = services.getProducts();
            objectOutput.writeObject(products);

            // Closing the connection
            socket.close();
            server.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
