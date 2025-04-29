package AdvancedOnlineShoppingSystem;

public class ClothingItem extends ShoppingItem {
    private String size;
    private double discountPercentage;

    public ClothingItem(String itemId, String itemName, String itemDescription, double price, int stockAvailable, String size, double discountPercentage) {
        super(itemId, itemName, itemDescription, price, stockAvailable);
        this.size = size;
        this.discountPercentage = discountPercentage;
    }

    @Override
    public void updateStock(int quantity) {
        this.stockAvailable -= quantity;
    }

    @Override
    public void addToCart(Customer customer) {
        if (stockAvailable > 0) {
            System.out.println("Added " + itemName + " in size " + size + " to " + customer.getCustomerName() + "'s cart.");
        } else {
            System.out.println("Sorry, " + itemName + " in size " + size + " is out of stock.");
        }
    }

    @Override
    public void generateInvoice(Customer customer) {
        double finalPrice = price * (1 - discountPercentage / 100);
        System.out.println("Generating invoice for " + customer.getCustomerName() + "...");
        System.out.println("Item: " + itemName + " (Size: " + size + ")");
        System.out.println("Price: $" + finalPrice);
    }

    @Override
    public void validateItem() {
        if (stockAvailable <= 0) {
            System.out.println("Item " + itemName + " is out of stock.");
        }
    }
}
