package AdvancedOnlineShoppingSystem;

import java.time.LocalDate;
import java.util.Scanner;

public class MainOnlineShopping {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Customer input
        System.out.print("Enter customer ID: ");
        String customerId = scanner.nextLine();
        System.out.print("Enter customer name: ");
        String customerName = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter address: ");
        String address = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String phone = scanner.nextLine();

        Customer customer = new Customer(customerId, customerName, email, address, phone);
        customer.validateCustomer();

        // Create cart
        ShoppingCart cart = new ShoppingCart("CART001", customer);

        // Item input loop
        System.out.print("How many different items do you want to add to the cart? ");
        int numItems = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numItems; i++) {
            System.out.println("\nItem #" + (i + 1));
            System.out.print("Enter item type (Electronics, Clothing, Groceries): ");
            String type = scanner.nextLine().trim().toLowerCase();

            System.out.print("Enter item ID: ");
            String id = scanner.nextLine();
            System.out.print("Enter item name: ");
            String name = scanner.nextLine();
            System.out.print("Enter description: ");
            String description = scanner.nextLine();
            System.out.print("Enter price: ");
            double price = Double.parseDouble(scanner.nextLine());
            System.out.print("Enter stock quantity: ");
            int stock = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter quantity to add to cart: ");
            int quantity = Integer.parseInt(scanner.nextLine());

            switch (type) {
                case "electronics":
                    System.out.print("Enter warranty period in months: ");
                    int warranty = Integer.parseInt(scanner.nextLine());
                    ElectronicsItem ei = new ElectronicsItem(id, name, description, price, stock, warranty);
                    cart.addItemToCart(ei, quantity);
                    break;

                case "clothing":
                    System.out.print("Enter size: ");
                    String size = scanner.nextLine();
                    System.out.print("Enter discount percent: ");
                    double discount = Double.parseDouble(scanner.nextLine());
                    ClothingItem ci = new ClothingItem(id, name, description, price, stock, size, discount);
                    cart.addItemToCart(ci, quantity);
                    break;

                case "groceries":
                    System.out.print("Enter expiration days from today: ");
                    int days = Integer.parseInt(scanner.nextLine());
                    GroceriesItem gi = new GroceriesItem(id, name, description, price, stock, LocalDate.now().plusDays(days));
                    cart.addItemToCart(gi, quantity);
                    break;

                default:
                    System.out.println("Invalid item type. Skipping.");
            }
        }

        // Display cart
        cart.showCart();

        // Payment input
        System.out.print("\nEnter payment method (Credit Card, PayPal): ");
        String paymentMethod = scanner.nextLine();
        System.out.print("Enter Total payment amount: ");
        double amountPaid = Double.parseDouble(scanner.nextLine());

        Payment payment = new Payment("P001", paymentMethod, amountPaid, LocalDate.now().toString());
        payment.validatePayment(cart.totalPrice);

        scanner.close();
    }
}
