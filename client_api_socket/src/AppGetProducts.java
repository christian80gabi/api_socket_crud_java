// by Christian80gabi
// com.christian80gabi.api.socket.client

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.List;

/**
 * Client Socket GetProducts (list of products)
 */
public class AppGetProducts {
    static int port = 5003;

    public static void main(String[] args) {
        try {
            // Creation of the Client Socket
            Socket socket;
            // Connection to the server
            socket = new Socket("localhost", port);
            System.out.println("Connected to localhost:" + port);

            // Communication ways (Input & Output)
            // Output (write)
            // OutputStream output = socket.getOutputStream();

            // Input (read)
            InputStream input = socket.getInputStream();
            ObjectInputStream objectInput = new ObjectInputStream(input);

            // Get the list of products from the server
            List<Product> products = (List<Product>) objectInput.readObject();

            if (products != null) {
                System.out.println("\nList of products:");
                for (Product p : products) {
                    System.out.println(p);
                }
            } else {
                System.out.println("No products!!!");
            }

            // Closing the connection
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
