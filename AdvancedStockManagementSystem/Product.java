package AdvancedStockManagementSystem;

public class Product {

    private int productId;
    private String productName;
    private String brand;
    private String supplier;
    private int stockQuantity = 0;

    // Constructor
    public Product(int productId, String productName, String brand, String supplier, int stockQuantity) {
        this.productId = productId;
        setProductName(productName);
        setBrand(brand);
        this.supplier = supplier;
        setStockQuantity(stockQuantity);
    }

    // Setters with validation
    private void setProductName(String productName) {
        if (productName == null || productName.trim().isEmpty()) {
            throw new IllegalArgumentException("Product name cannot be empty.");
        }
        this.productName = productName;
    }

    private void setBrand(String brand) {
        if (brand == null || brand.trim().isEmpty()) {
            throw new IllegalArgumentException("Brand cannot be empty.");
        }
        this.brand = brand;
    }

    private void setStockQuantity(int stockQuantity) {
        if (stockQuantity < 0) {
            throw new IllegalArgumentException("Stock quantity cannot be negative.");
        }
        this.stockQuantity = stockQuantity;
    }

    // A simple method to display product info
    public void displayProductInfo() {
        System.out.println("=== Product Information ===");
        System.out.println("Product ID: " + productId);
        System.out.println("Product Name: " + productName);
        System.out.println("Brand: " + brand);
        System.out.println("Supplier: " + supplier);
        System.out.println("Stock Quantity: " + stockQuantity);
    }

    // Optional: Add methods to update stock, change supplier, etc.
}
