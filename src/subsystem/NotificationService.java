package subsystem;

public class NotificationService {
    public void sendOrderConfirmation(String email, String orderId) {
        System.out.println("[Notification] Sending Order Confirmation for " + orderId + " to " + email);
    }

    public void sendCancellationNotice(String email, String orderId) {
        System.out.println("[Notification] Sending Cancellation Notice for " + orderId + " to " + email);
    }
}