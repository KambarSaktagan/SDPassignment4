import facade.OrderFacade;
import model.Cart;
import model.Customer;

public class Main {
    public static void main(String[] args) {
        OrderFacade orderSystem = new OrderFacade();

        Customer customer = new Customer("Kambar Saktagan", "kambar@example.com");
        Cart cart = new Cart("MacBook Pro M3", 1);
        double totalAmount = 1999.99;
        String shippingAddress = "Astana IT University, EXPO Business Center, Astana";

        String orderId = orderSystem.placeOrder(cart, customer, totalAmount, shippingAddress);

        if (orderId != null) {
            orderSystem.cancelOrder(orderId, cart, customer, totalAmount, "TRK-EXAMPLE");
        }
    }
}