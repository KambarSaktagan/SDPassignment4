package facade;

import model.Cart;
import model.Customer;
import subsystem.InventoryService;
import subsystem.NotificationService;
import subsystem.PaymentProcessor;
import subsystem.ShippingService;

public class OrderFacade {
    private final InventoryService inventoryService;
    private final PaymentProcessor paymentProcessor;
    private final ShippingService shippingService;
    private final NotificationService notificationService;

    public OrderFacade() {
        this.inventoryService = new InventoryService();
        this.paymentProcessor = new PaymentProcessor();
        this.shippingService = new ShippingService();
        this.notificationService = new NotificationService();
    }

    public String placeOrder(Cart cart, Customer customer, double amount, String address) {
        System.out.println("\n--- Initiating Order Placement ---");
        String orderId = "ORD-" + System.currentTimeMillis();

        if (!inventoryService.reserveItem(cart.itemId(), cart.quantity())) {
            System.out.println("-> Order Failed: Item out of stock.");
            return null;
        }

        if (!paymentProcessor.processPayment(customer.name(), amount)) {
            System.out.println("-> Order Failed: Payment declined. Rolling back inventory.");
            inventoryService.releaseItem(cart.itemId(), cart.quantity());
            return null;
        }

        String trackingId = shippingService.arrangeShipping(cart.itemId(), address);

        notificationService.sendOrderConfirmation(customer.email(), orderId);

        System.out.println("-> Order " + orderId + " successfully placed. (Tracking: " + trackingId + ")");
        return orderId;
    }

    public void cancelOrder(String orderId, Cart cart, Customer customer, double amount, String trackingId) {
        System.out.println("\n--- Initiating Order Cancellation: " + orderId + " ---");

        shippingService.cancelShipping(trackingId);
        paymentProcessor.refundPayment(customer.name(), amount);
        inventoryService.releaseItem(cart.itemId(), cart.quantity());
        notificationService.sendCancellationNotice(customer.email(), orderId);

        System.out.println("-> Order canceled successfully.");
    }
}