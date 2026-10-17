package subsystem;

public class InventoryService {
    public boolean reserveItem(String itemId, int quantity) {
        System.out.println("[Inventory] Reserving " + quantity + "x of item: " + itemId);
        return true;
    }

    public void releaseItem(String itemId, int quantity) {
        System.out.println("[Inventory] Releasing " + quantity + "x of item: " + itemId + " back to stock.");
    }
}