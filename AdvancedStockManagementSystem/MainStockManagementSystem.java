package AdvancedStockManagementSystem;

import java.time.LocalDate;
import java.util.Scanner;

public class MainStockManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create and add Stock Items (Demonstration purposes)
        System.out.print("Enter item ID: ");
        String itemId = scanner.nextLine();

        System.out.print("Enter item name: ");
        String itemName = scanner.nextLine();

        System.out.print("Enter quantity in stock: ");
        int quantity = scanner.nextInt();

        System.out.print("Enter price per unit: ");
        double price = scanner.nextDouble();
        scanner.nextLine();  // Consume newline

        System.out.print("Enter category: ");
        String category = scanner.nextLine();

        System.out.print("Enter supplier: ");
        String supplier = scanner.nextLine();

        // Choose item type
        System.out.println("Choose item type (1-Electronics, 2-Clothing, 3-Grocery, 4-Furniture, 5-Perishable): ");
        int choice = scanner.nextInt();

        StockItem item = null;

        switch (choice) {
            case 1:
                System.out.print("Enter warranty period (in months): ");
                int warrantyPeriod = scanner.nextInt();
                item = new ElectronicsItem(itemId, itemName, quantity, price, category, supplier, warrantyPeriod);
                break;
            case 2:
                System.out.print("Enter size: ");
                String size = scanner.nextLine();
                System.out.print("Enter color: ");
                String color = scanner.nextLine();
                System.out.print("Enter discount percentage: ");
                double discount = scanner.nextDouble();
                item = new ClothingItem(itemId, itemName, quantity, price, category, supplier, size, color, discount);
                break;
            case 3:
                System.out.print("Enter expiration date (YYYY-MM-DD): ");
                String expirationDate = scanner.nextLine();
                item = new GroceryItem(itemId, itemName, quantity, price, category, supplier, LocalDate.parse(expirationDate));
                break;
            case 4:
                System.out.print("Enter weight (in kg): ");
                double weight = scanner.nextDouble();
                item = new FurnitureItem(itemId, itemName, quantity, price, category, supplier, weight);
                break;
            case 5:
                System.out.print("Enter shelf life date (YYYY-MM-DD): ");
                String shelfLifeDate = scanner.nextLine();
                item = new PerishableItem(itemId, itemName, quantity, price, category, supplier, LocalDate.parse(shelfLifeDate));
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }

        if (item != null) {
            // Update stock and display report
            item.updateStock(10); // Example of stock update
            item.calculateStockValue();
            item.generateStockReport();
            item.validateStock();
        }

        scanner.close();
    }
}
