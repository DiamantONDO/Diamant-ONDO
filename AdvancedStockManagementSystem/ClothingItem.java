package AdvancedStockManagementSystem;

public class ClothingItem extends StockItem {
    private String size;
    private String color;
    private double discountPercentage;

    public ClothingItem(String itemId, String itemName, int quantityInStock, double pricePerUnit, String category, String supplier, String size, String color, double discountPercentage) {
        super(itemId, itemName, quantityInStock, pricePerUnit, category, supplier);
        this.size = size;
        this.color = color;
        this.discountPercentage = discountPercentage;
    }

    @Override
    public void updateStock(int quantity) {
        this.quantityInStock += quantity;
        System.out.println("Stock updated: " + quantity + " items. Current stock: " + quantityInStock);
    }

    @Override
    public void calculateStockValue() {
        double stockValue = quantityInStock * pricePerUnit;
        if (discountPercentage > 0) {
            stockValue *= (1 - discountPercentage / 100);
        }
        System.out.println("Stock value of " + itemName + ": $" + stockValue);
    }

    @Override
    public void generateStockReport() {
        System.out.println("==== Clothing Item Report ====");
        System.out.println("Item ID: " + itemId);
        System.out.println("Name: " + itemName);
        System.out.println("Category: " + category);
        System.out.println("Size: " + size);
        System.out.println("Color: " + color);
        System.out.println("Price per unit: $" + pricePerUnit);
        System.out.println("Discount: " + discountPercentage + "%");
        System.out.println("Supplier: " + supplier);
        System.out.println("Quantity in stock: " + quantityInStock);
    }

    @Override
    public void validateStock() {
        if (quantityInStock <= 0) {
            System.out.println("Error: Stock quantity for clothing items must be above zero.");
        }
    }
}
