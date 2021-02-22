package com.christian80gabi.api.socket.test;

import com.christian80gabi.api.socket.services.Services;

/**
 * Test Class
 */
public class App {
    public static void main(String[] args) {
        Services services = new Services();

        // com.christian80gabi.api.socket.models.Product prod = new com.christian80gabi.api.socket.models.Product("Desk", 79.99,16);
        /*System.out.println(prod);
        services.addProduct(prod);
         */

        // services.getProduct("C9582CAAE3A646DBB1B5D4288937AAD8");
        
        // services.deleteProduct("2F13A4099F094860B14A05EFD880978E");

        services.getProducts();

        // prod.setReference("C9582CAAE3A646DBB1B5D4288937AAD9");
        // services.updateProduct(prod);
        
    }
}
