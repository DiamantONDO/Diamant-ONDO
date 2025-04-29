package AdvancedOnlineShoppingSystem;

public class Payment {
    private String paymentId;
    private String paymentMethod;
    private double amountPaid;
    private String transactionDate;

    public Payment(String paymentId, String paymentMethod, double amountPaid, String transactionDate) {
        this.paymentId = paymentId;
        this.paymentMethod = paymentMethod;
        this.amountPaid = amountPaid;
        this.transactionDate = transactionDate;
    }

    public void validatePayment(double totalPrice) {
        if (amountPaid != totalPrice) {
            System.out.println("Error: Payment amount doesn't match total price.");
        } else {
            System.out.println("Payment validated. Thank you for your purchase.");
        }
    }
}
