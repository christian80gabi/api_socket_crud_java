package com.christian80gabi.api.socket.services;

import com.christian80gabi.api.socket.models.Product;

import java.util.List;

public interface ProductServices {
    public void addProduct(Product product);
    public Product getProduct(String reference);
    public List<Product> getProducts();
    public void updateProduct(Product product);
    public void deleteProduct(String reference);
}
