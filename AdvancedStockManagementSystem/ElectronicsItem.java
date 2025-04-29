package AdvancedStockManagementSystem;

public class ElectronicsItem extends StockItem {
    private int warrantyPeriod; // In months

    public ElectronicsItem(String itemId, String itemName, int quantityInStock, double pricePerUnit, String category, String supplier, int warrantyPeriod) {
        super(itemId, itemName, quantityInStock, pricePerUnit, category, supplier);
        this.warrantyPeriod = warrantyPeriod;
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
        System.out.println("==== Electronics Item Report ====");
        System.out.println("Item ID: " + itemId);
        System.out.println("Name: " + itemName);
        System.out.println("Category: " + category);
        System.out.println("Price per unit: $" + pricePerUnit);
        System.out.println("Warranty: " + warrantyPeriod + " months");
        System.out.println("Supplier: " + supplier);
        System.out.println("Quantity in stock: " + quantityInStock);
    }

    @Override
    public void validateStock() {
        if (quantityInStock <= 0) {
            System.out.println("Error: Stock quantity for electronics must be above zero for sale.");
        }
    }

    public void applyDiscount(double discountPercentage) {
        if (discountPercentage > 50) {
            System.out.println("Discount cannot exceed 50%.");
        } else {
            pricePerUnit = pricePerUnit * (1 - discountPercentage / 100);
            System.out.println("Discount applied! New price: $" + pricePerUnit);
        }
    }
}
