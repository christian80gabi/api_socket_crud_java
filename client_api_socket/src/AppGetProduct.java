// by Christian80gabi
// com.christian80gabi.api.socket.client

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * Client Socket GetProduct (a single product)
 */
public class AppGetProduct {
    static int port = 5002;

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
            PrintWriter writer = new PrintWriter(output, true); // Auto-write set to True
            // Input (read)
            InputStream input = socket.getInputStream();
            ObjectInputStream objectInput = new ObjectInputStream(input);

            // Create a Product object
            Product product;

            // Get from the database a specified product referenced by its reference
            Scanner scanner = new Scanner(System.in);
            System.out.println("\n\nType a product reference: ");
            String reference = scanner.next();

            // Sending the request to the server
            System.out.println("We'll look for it in our database for you...\n");
            writer.println(reference);

            System.out.println("And the answer is... Wait for it...\n");
            product = (Product) objectInput.readObject();

            if (product != null && product.getReference() != null) {
                System.out.println("=> Product found :)");
                System.out.println(product);
            } else {
                System.out.println("=> No Product found :(");
            }

            // Closing the connection
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
