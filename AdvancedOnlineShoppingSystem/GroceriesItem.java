package AdvancedOnlineShoppingSystem;

import java.time.LocalDate;

public class GroceriesItem extends ShoppingItem {
    private LocalDate expirationDate;

    public GroceriesItem(String itemId, String itemName, String itemDescription, double price, int stockAvailable, LocalDate expirationDate) {
        super(itemId, itemName, itemDescription, price, stockAvailable);
        this.expirationDate = expirationDate;
    }

    @Override
    public void updateStock(int quantity) {
        this.stockAvailable -= quantity;
    }

    @Override
    public void addToCart(Customer customer) {
        if (stockAvailable > 0) {
            System.out.println("Added " + itemName + " to " + customer.getCustomerName() + "'s cart.");
        } else {
            System.out.println("Sorry, " + itemName + " is out of stock.");
        }
    }

    @Override
    public void generateInvoice(Customer customer) {
        System.out.println("Generating invoice for " + customer.getCustomerName() + "...");
        System.out.println("Item: " + itemName);
        System.out.println("Price: $" + price);
        System.out.println("Expiration Date: " + expirationDate);
    }

    @Override
    public void validateItem() {
        if (stockAvailable <= 0) {
            System.out.println("Item " + itemName + " is out of stock.");
        }
        if (expirationDate.isBefore(LocalDate.now())) {
            System.out.println("Warning: " + itemName + " has expired.");
        }
    }
}
