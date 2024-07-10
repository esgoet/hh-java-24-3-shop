import order.Order;
import order.OrderMapRepo;
import product.Product;
import product.ProductRepo;

import static java.util.Map.entry;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        OrderMapRepo orderRepo = new OrderMapRepo();
        ProductRepo productRepo = new ProductRepo();
        ShopService shopService = new ShopService(orderRepo, productRepo);

        Product cucumber = new Product("Cucumber", 0.79);
        Product banana = new Product("Banana", 0.20);
        Product orange = new Product("Orange", 0.45);
        Product broccoli = new Product("Broccoli", 1.29);

        Order fruitOrder = new Order(Map.ofEntries(entry(orange,5), entry(banana,20)));
        Order vegetableOrder = new Order(Map.ofEntries(entry(broccoli, 12), entry(cucumber, 5)));
        System.out.println(fruitOrder);
        System.out.println(fruitOrder.getTotalPrice());

        shopService.placeOrder(fruitOrder);
        shopService.placeOrder(vegetableOrder);

        shopService.getOrderRepo().modifySingle(vegetableOrder.id(), broccoli, 45);
        shopService.isOrderAvailable(shopService.getOrderRepo().getSingle(fruitOrder.id()));
        shopService.receiveOrder(shopService.getOrderRepo().getSingle(fruitOrder.id()));
        shopService.isOrderAvailable(shopService.getOrderRepo().getSingle(fruitOrder.id()));
        shopService.receiveOrder(shopService.getOrderRepo().getSingle(vegetableOrder.id()));


        System.out.println(shopService.getOrderRepo());
        System.out.println(shopService.getProductRepo());
    }
}
