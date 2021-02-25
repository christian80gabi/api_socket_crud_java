// by Christian80gabi
// com.christian80gabi.api.socket.client

import java.io.*;
import java.net.Socket;

/**
 * Client Socket
 */
public class App {
    public static void main(String[] args) {
        try {
            // Creation of the Client Socket
            Socket socket;
            // Connection to the server
            socket = new Socket("localhost", 5000);
            // Communication ways (Input & Output)
            // Output (write)
            OutputStream output = socket.getOutputStream();
            ObjectOutputStream objectOutput = new ObjectOutputStream(output);
            // Input (read)
            InputStream input = socket.getInputStream();
            ObjectInputStream objectInput = new ObjectInputStream(input);

            Product product = new Product("Bag", 60.0, 50);

            // Sending an Object to the server
            System.out.println("Envoie de l'objet sérialisé au serveur");
            objectOutput.writeObject(product);

            // Closing the connection
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
