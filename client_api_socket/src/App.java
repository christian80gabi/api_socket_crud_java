import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class App {
    public static void main(String[] args) {
        try {
            Socket socket;
            socket = new Socket("localhost", 5000);

            OutputStream output = socket.getOutputStream();
            ObjectOutputStream objectOutput = new ObjectOutputStream(output);

            Product product = new Product(1, "Book", 32.0, 30);

            System.out.println("Envoie de l'objet sérialisé au serveur");

            objectOutput.writeObject(product);

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
