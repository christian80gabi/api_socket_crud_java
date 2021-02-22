package com.christian80gabi.api.socket.dao;

import com.christian80gabi.api.socket.database.ConnectionSingleton;
import com.christian80gabi.api.socket.models.Product;
import com.christian80gabi.api.socket.services.ProductServices;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDao implements ProductServices {

    static Connection getConnection() {
        System.out.println("MySQL Database connection...");
        return ConnectionSingleton.getConnection();
    }

    @Override
    public void addProduct(Product product) {
        System.out.println("Adding a product referenced by: " + product.getReference());
        Connection conn = getConnection();
        String sql = "INSERT INTO products (reference, name, price, quantity) VALUE (?, ?, ?, ?)";

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, product.getReference());
            pstmt.setString(2, product.getName());
            pstmt.setDouble(3, product.getPrice());
            pstmt.setInt(4, product.getQuantity());

            pstmt.executeUpdate();
            pstmt.close();

            System.out.println("Operation finished...");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public Product getProduct(String reference) {
        System.out.println("Looking for a product referenced by: " + reference);
        Connection conn = getConnection();
        Product product = null;
        String sql = "SELECT * FROM products WHERE reference = ?";

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, reference);

            ResultSet rs = pstmt.executeQuery();

            if (rs != null) {
                if (rs.next()) {
                    product = new Product();
                    product.setId(rs.getInt("id"));
                    product.setReference(rs.getString("reference"));
                    product.setName(rs.getString("name"));
                    product.setPrice(rs.getDouble("price"));
                    product.setQuantity(rs.getInt("quantity"));
                }
            }

            pstmt.close();
            System.out.println("Operation finished...");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // if (product == null) throw new RuntimeException("No com.christian80gabi.api.socket.models.Product found");

        return product;
    }

    @Override
    public List<Product> getProducts() {
        System.out.println("Getting the list of products...");
        Connection conn = getConnection();
        List<Product> products = null;
        String sql = "SELECT * FROM products";

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery();

            if (rs != null) {
                products = new ArrayList<Product>();
                while (rs.next()) {
                    Product product = new Product();
                    product.setId(rs.getInt("id"));
                    product.setReference(rs.getString("reference"));
                    product.setName(rs.getString("name"));
                    product.setPrice(rs.getDouble("price"));
                    product.setQuantity(rs.getInt("quantity"));
                    products.add(product);
                }
            }

            pstmt.close();
            System.out.println("Operation finished...");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // if (product == null) throw new RuntimeException("No com.christian80gabi.api.socket.models.Product found");

        return products;
    }

    @Override
    public void updateProduct(Product product) {
        System.out.println("Updating the product referenced by: " + product.getReference());
        Connection conn = getConnection();
        String sql ="UPDATE products SET name = ?, price = ?, quantity = ? WHERE reference = ?";

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, product.getName());
            pstmt.setDouble(2, product.getPrice());
            pstmt.setInt(3, product.getQuantity());
            pstmt.setString(4, product.getReference());

            pstmt.executeUpdate();

            pstmt.close();
            System.out.println("Operation finished...");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteProduct(String reference) {
        System.out.println("Deleting the product referenced by: " + reference);
        Connection conn = getConnection();
        String sql = "DELETE FROM products WHERE reference = ?";

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, reference);

            pstmt.executeUpdate();

            pstmt.close();
            System.out.println("Operation finished...");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
