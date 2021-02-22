import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Server Socket
 */
public class App {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(5000);

            Socket socket = server.accept();

            InputStream input = socket.getInputStream();
            ObjectInputStream objectInput = new ObjectInputStream(input);

            System.out.println("Attente d'un objet du client...");
            Product product = (Product) objectInput.readObject();

            System.out.println("The received product is:\n" + product);

            socket.close();
            server.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
