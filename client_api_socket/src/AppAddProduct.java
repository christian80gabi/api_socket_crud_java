// by Christian80gabi
// com.christian80gabi.api.socket.client

import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * Client Socket AddProduct
 */
public class AppAddProduct {
    static Scanner sc = new Scanner(System.in);
    static int port = 5001;

    public static void main(String[] args) {
        try {
            // Creation of the Client Socket
            Socket socket;
            // Connection to the server
            socket = new Socket("localhost", port);
            System.out.println("Connected to localhost:" + port);

            // Communication ways (Input & Output)
            // Output (write)
            OutputStream output = socket.getOutputStream();
            ObjectOutputStream objectOutput = new ObjectOutputStream(output);

            // Create a Product object
            Product product;

            System.out.println("Let's create product!\n");
            System.out.print("Product name: ");
            String name = sc.next();
            System.out.print("Product price: ");
            double price = sc.nextDouble();
            System.out.print("Product quantity: ");
            int quantity = sc.nextInt();

            product = new Product(name, price, quantity);

            // Sending an Object to the server
            System.out.println("Sending a Serialized Object to the Server");
            objectOutput.writeObject(product);

            // Closing the connection
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
