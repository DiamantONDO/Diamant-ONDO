package AdvancedStockManagementSystem;

import java.time.LocalDate;

public class GroceryItem extends StockItem {
    private LocalDate expirationDate;

    public GroceryItem(String itemId, String itemName, int quantityInStock, double pricePerUnit, String category, String supplier, LocalDate expirationDate) {
        super(itemId, itemName, quantityInStock, pricePerUnit, category, supplier);
        this.expirationDate = expirationDate;
    }

    @Override
    public void updateStock(int quantity) {
        this.quantityInStock += quantity;
        System.out.println("Stock updated: " + quantity + " items. Current stock: " + quantityInStock);
    }

    @Override
    public void calculateStockValue() {
        double stockValue = quantityInStock * pricePerUnit;
        System.out.println("Stock value of " + itemName + ": $" + stockValue);
    }

    @Override
    public void generateStockReport() {
        System.out.println("==== Grocery Item Report ====");
        System.out.println("Item ID: " + itemId);
        System.out.println("Name: " + itemName);
        System.out.println("Category: " + category);
        System.out.println("Price per unit: $" + pricePerUnit);
        System.out.println("Expiration Date: " + expirationDate);
        System.out.println("Supplier: " + supplier);
        System.out.println("Quantity in stock: " + quantityInStock);
    }

    @Override
    public void validateStock() {
        if (quantityInStock <= 0) {
            System.out.println("Error: Stock quantity for grocery items must be above zero.");
        }

        if (expirationDate.isBefore(LocalDate.now())) {
            System.out.println("Warning: Grocery item " + itemName + " has expired.");
        }
    }
}
