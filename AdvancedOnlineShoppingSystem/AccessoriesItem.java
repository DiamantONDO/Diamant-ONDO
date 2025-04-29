package AdvancedOnlineShoppingSystem;

public class AccessoriesItem extends ShoppingItem {
    private String color;

    public AccessoriesItem(String itemId, String itemName, String itemDescription, double price, int stockAvailable, String color) {
        super(itemId, itemName, itemDescription, price, stockAvailable);
        this.color = color;
    }

    @Override
    public void updateStock(int quantity) {
        this.stockAvailable -= quantity;
    }

    @Override
    public void addToCart(Customer customer) {
        if (stockAvailable > 0) {
            System.out.println("Added " + itemName + " (Color: " + color + ") to " + customer.getCustomerName() + "'s cart.");
        } else {
            System.out.println("Sorry, " + itemName + " is out of stock.");
        }
    }

    @Override
    public void generateInvoice(Customer customer) {
        System.out.println("Generating invoice for " + customer.getCustomerName() + "...");
        System.out.println("Item: " + itemName);
        System.out.println("Price: $" + price);
        System.out.println("Color: " + color);
    }

    @Override
    public void validateItem() {
        if (stockAvailable <= 0) {
            System.out.println("Item " + itemName + " is out of stock.");
        }
    }
}
