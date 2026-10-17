package subsystem;

public class PaymentProcessor {
    public boolean processPayment(String customerName, double amount) {
        System.out.println("[Payment] Processing $" + amount + " charge for " + customerName);
        return true;
    }

    public void refundPayment(String customerName, double amount) {
        System.out.println("[Payment] Refunding $" + amount + " to " + customerName);
    }
}