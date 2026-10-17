package subsystem;

import java.util.UUID;

public class ShippingService {
    public String arrangeShipping(String itemId, String address) {
        String trackingId = "TRK-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        System.out.println("[Shipping] Arranging shipment to " + address + ". Tracking: " + trackingId);
        return trackingId;
    }

    public void cancelShipping(String trackingId) {
        System.out.println("[Shipping] Canceling shipment for Tracking ID: " + trackingId);
    }
}