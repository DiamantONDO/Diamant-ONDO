package AdvancedStockManagementSystem;

import java.time.LocalDate;

public class PerishableItem extends StockItem {
    private LocalDate shelfLife;

    public PerishableItem(String itemId, String itemName, int quantityInStock, double pricePerUnit, String category, String supplier, LocalDate shelfLife) {
        super(itemId, itemName, quantityInStock, pricePerUnit, category, supplier);
        this.shelfLife = shelfLife;
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
        System.out.println("==== Perishable Item Report ====");
        System.out.println("Item ID: " + itemId);
        System.out.println("Name: " + itemName);
        System.out.println("Category: " + category);
        System.out.println("Price per unit: $" + pricePerUnit);
        System.out.println("Shelf Life: " + shelfLife);
        System.out.println("Supplier: " + supplier);
        System.out.println("Quantity in stock: " + quantityInStock);
    }

    @Override
    public void validateStock() {
        if (quantityInStock <= 0) {
            System.out.println("Error: Stock quantity for perishable items must be above zero.");
        }

        if (shelfLife.isBefore(LocalDate.now())) {
            System.out.println("Warning: Perishable item " + itemName + " is expired.");
        }
    }
}
