package com.christian80gabi.api.socket.services;

import com.christian80gabi.api.socket.dao.ProductDao;
import com.christian80gabi.api.socket.models.Product;

import java.util.List;

public class Services {
    ProductServices service = new ProductDao();

    public void addProduct(Product product) {
        service.addProduct(product);
        System.out.println("com.christian80gabi.api.socket.models.Product added successfully!!!");
    }

    public void getProduct(String reference) {
        Product product =  service.getProduct(reference);
        if (product != null) {
            System.out.println("com.christian80gabi.api.socket.models.Product found!!!");
            System.out.println(product);
        } else {
            System.out.println("No com.christian80gabi.api.socket.models.Product found!!!");
        }
    }

    public void getProducts() {
        List<Product> products = service.getProducts();

        if (products != null) {
            System.out.println("\nList of products:");
            for (Product product : products) {
                System.out.println(product);
            }
        } else {
            System.out.println("No products!!!");
        }
    }

    public void updateProduct(Product product) {
        service.updateProduct(product);
        System.out.println("com.christian80gabi.api.socket.models.Product updated successfully!!!");
    }

    public void deleteProduct(String reference) {
        service.deleteProduct(reference);
        System.out.println("com.christian80gabi.api.socket.models.Product deleted successfully!!!");
    }
}
