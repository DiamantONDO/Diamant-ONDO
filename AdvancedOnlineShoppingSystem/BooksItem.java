package AdvancedOnlineShoppingSystem;

public class BooksItem extends ShoppingItem {
    private String ISBN;

    public BooksItem(String itemId, String itemName, String itemDescription, double price, int stockAvailable, String ISBN) {
        super(itemId, itemName, itemDescription, price, stockAvailable);
        this.ISBN = ISBN;
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
        System.out.println("ISBN: " + ISBN);
    }

    @Override
    public void validateItem() {
        if (stockAvailable <= 0) {
            System.out.println("Item " + itemName + " is out of stock.");
        }
    }
}
