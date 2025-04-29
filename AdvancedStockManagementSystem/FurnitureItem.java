package AdvancedStockManagementSystem;

public class FurnitureItem extends StockItem {
    private double weight; // in kg

    public FurnitureItem(String itemId, String itemName, int quantityInStock, double pricePerUnit, String category, String supplier, double weight) {
        super(itemId, itemName, quantityInStock, pricePerUnit, category, supplier);
        this.weight = weight;
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
        System.out.println("==== Furniture Item Report ====");
        System.out.println("Item ID: " + itemId);
        System.out.println("Name: " + itemName);
        System.out.println("Category: " + category);
        System.out.println("Price per unit: $" + pricePerUnit);
        System.out.println("Weight: " + weight + " kg");
        System.out.println("Supplier: " + supplier);
        System.out.println("Quantity in stock: " + quantityInStock);
    }

    @Override
    public void validateStock() {
        if (quantityInStock <= 0) {
            System.out.println("Error: Stock quantity for furniture items must be above zero.");
        }
        System.out.println("Furniture item " + itemName + " is validated for packing.");
    }
}
