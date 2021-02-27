// by Christian80gabi
// com.christian80gabi.api.socket.test

/**
 * Test Class
 */
public class AppTestServices {
    public static void main(String[] args) {
        Services services = new Services();

        Product prod = new Product("Desk", 79.99,16);
        System.out.println(prod);
        services.addProduct(prod);

        services.getProduct("C9582CAAE3A646DBB1B5D4288937AAD8");
        
        services.deleteProduct("2F13A4099F094860B14A05EFD880978E");

        services.getProducts();

        prod.setReference("C9582CAAE3A646DBB1B5D4288937AAD9");
        services.updateProduct(prod);
        
    }
}
