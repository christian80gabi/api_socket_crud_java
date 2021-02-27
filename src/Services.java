// By christian80gabi
// package com.christian80gabi.api.socket.services

import java.util.List;

public class Services {
    ProductServices service = new ProductDao();

    public void addProduct(Product product) {
        service.addProduct(product);
        System.out.println("Product added successfully!!!");
    }

    public Product getProduct(String reference) {
       return service.getProduct(reference);
    }

    public List<Product> getProducts() {
        return service.getProducts();
    }

    public void updateProduct(Product product) {
        service.updateProduct(product);
        System.out.println("Product updated successfully!!!");
    }

    public void deleteProduct(String reference) {
        service.deleteProduct(reference);
        System.out.println("Product deleted successfully!!!");
    }
}
