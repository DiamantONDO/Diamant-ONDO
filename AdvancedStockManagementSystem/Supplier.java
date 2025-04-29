package AdvancedStockManagementSystem;

import java.util.regex.Pattern;

public class Supplier {

    private String supplierId;
    private String companyName;
    private String contactPerson;
    private String phone;
    private String email;

    public Supplier(String supplierId, String companyName, String contactPerson, String phone, String email) {
        this.supplierId = supplierId;
        this.companyName = companyName;
        this.contactPerson = contactPerson;
        setPhone(phone);
        setEmail(email);
    }

    private void setPhone(String phone) {
        // Simple validation: must be 10-15 digits
        if (phone.matches("\\d{10,15}")) {
            this.phone = phone;
        } else {
            throw new IllegalArgumentException("Invalid phone number. It should have 10 to 15 digits.");
        }
    }

    private void setEmail(String email) {
        // Simple regex to validate email format
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        if (Pattern.matches(emailRegex, email)) {
            this.email = email;
        } else {
            throw new IllegalArgumentException("Invalid email format.");
        }
    }

    public void displaySupplierInfo() {
        System.out.println("=== Supplier Information ===");
        System.out.println("Supplier ID: " + supplierId);
        System.out.println("Company Name: " + companyName);
        System.out.println("Contact Person: " + contactPerson);
        System.out.println("Phone: " + phone);
        System.out.println("Email: " + email);
    }
}
