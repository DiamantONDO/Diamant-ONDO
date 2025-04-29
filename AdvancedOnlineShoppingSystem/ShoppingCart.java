package AdvancedOnlineShoppingSystem;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private String cartId;
    private List<ShoppingItem> cartItems;
    double totalPrice;
    private Customer customer;

    public ShoppingCart(String cartId, Customer customer) {
        this.cartId = cartId;
        this.cartItems = new ArrayList<>();
        this.customer = customer;
        this.totalPrice = 0;
    }

    public void addItemToCart(ShoppingItem item, int quantity) {
        if (item != null && item.stockAvailable >= quantity) {
            cartItems.add(item);
            totalPrice += item.price * quantity;
            item.updateStock(quantity);
            System.out.println(quantity + " " + item.itemName + " added to cart.");
        } else {
            System.out.println("Error: Insufficient stock or invalid item.");
        }
    }

    public void removeItemFromCart(ShoppingItem item) {
        if (cartItems.contains(item)) {
            cartItems.remove(item);
            totalPrice -= item.price;
            System.out.println(item.itemName + " removed from cart.");
        } else {
            System.out.println("Item not found in cart.");
        }
    }

    public void showCart() {
        System.out.println("==== Shopping Cart ====");
        for (ShoppingItem item : cartItems) {
            System.out.println(item.itemName + " - $" + item.price);
        }
        System.out.println("Total Price: $" + totalPrice);
    }
}
