// by Christian80gabi
// com.christian80gabi.api.socket

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Server Socket
 */
public class App {
    public static void main(String[] args) {
        try {
            // Creation of the Server Socket
            ServerSocket server = new ServerSocket(5000);
            // Accepting connection from a client
            Socket socket = server.accept();

            // Communication ways (Input & Output)
            // Output (write)
            OutputStream output = socket.getOutputStream();
            ObjectOutputStream objectOutput = new ObjectOutputStream(output);
            // Input (read)
            InputStream input = socket.getInputStream();
            ObjectInputStream objectInput = new ObjectInputStream(input);

            // Services | Products services
            Services services = new Services();

            Product product = new Product();

            // receiving an Object from the client
            System.out.println("Attente d'un objet du client...");
            product = (Product) objectInput.readObject();

            // Adding a product in the database
            services.addProduct(product);

            System.out.println("The received product is:\n" + product);

            // Closing the connection
            socket.close();
            server.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
