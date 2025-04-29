package AdvancedOnlineShoppingSystem;

public class Customer {
    private String customerId;
    private String customerName;
    private String email;
    private String address;
    private String phone;

    public Customer(String customerId, String customerName, String email, String address, String phone) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.email = email;
        this.address = address;
        this.phone = phone;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void validateCustomer() {
        if (address.isEmpty() || phone.isEmpty() || email.isEmpty()) {
            System.out.println("Error: Please ensure that your details are complete.");
        }
    }
}
