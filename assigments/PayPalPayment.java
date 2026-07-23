interface Payable {
    void processPayment(double amount);
    String getPaymentStatus();
    void refundPayment(double amount);
}

interface Taxable {
    double calculateTax();
    void generateTaxInvoice();
}

interface Loggable {
    void logActivity(String action);
}

public class PayPalPayment implements Payable, Taxable, Loggable {

    private String email;
    private String status = "PENDING";
    private double amount;
    private double tax;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void processPayment(double amount) {
        this.amount = amount;
        status = "SUCCESS";
        tax = calculateTax();

        System.out.println("Payment of ₹" + amount + " processed using PayPal.");
        logActivity("Payment Processed");
    }

    @Override
    public String getPaymentStatus() {
        return status;
    }

    @Override
    public void refundPayment(double amount) {
        status = "REFUNDED";
        System.out.println("Refund of ₹" + amount + " completed.");
        logActivity("Refund Processed");
    }

    @Override
    public double calculateTax() {
        tax = amount * 0.18;
        return tax;
    }

    @Override
    public void generateTaxInvoice() {
        System.out.println("\n------ PayPal Tax Invoice ------");
        System.out.println("Email        : " + email);
        System.out.println("Amount       : ₹" + amount);
        System.out.println("GST (18%)    : ₹" + tax);
        System.out.println("Total Amount : ₹" + (amount + tax));
    }

    @Override
    public void logActivity(String action) {
        System.out.println("LOG : " + action);
    }

    public void loginToPayPal() {
        System.out.println("Logged into PayPal Account.");
    }

    public void verifyEmail() {
        System.out.println("Email Verified Successfully.");
    }

    public void checkBalance() {
        System.out.println("Balance Checked.");
    }

    public void sendReceipt() {
        System.out.println("Receipt sent to " + email);
    }

    public void logout() {
        System.out.println("Logged out successfully.");
    }

    public static void main(String[] args) {

        PayPalPayment paypal = new PayPalPayment("user@gmail.com");

        paypal.loginToPayPal();
        paypal.verifyEmail();
        paypal.checkBalance();

        paypal.processPayment(2500);

        System.out.println("Status : " + paypal.getPaymentStatus());

        paypal.generateTaxInvoice();

        paypal.sendReceipt();

        paypal.refundPayment(500);

        System.out.println("Updated Status : " + paypal.getPaymentStatus());

        paypal.logout();
    }
}