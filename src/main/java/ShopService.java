import order.Order;
import order.OrderRepo;
import product.Product;
import product.ProductRepo;

public class ShopService {
    OrderRepo orderRepo;
    ProductRepo productRepo;

    public ShopService() {

    }

    public ShopService(OrderRepo orderRepo, ProductRepo productRepo) {
        this.orderRepo = orderRepo;
        this.productRepo = productRepo;
    }

    public void placeOrder(Order order) {
        orderRepo.add(order);
    }

    public void receiveOrder(Order order) {
        for (Product product : order.products().keySet()) {
            for (int i = 0; i < order.products().get(product); i++) {
                productRepo.add(product);
            }
        }
    }

    public boolean isOrderAvailable(Order order) {
        int count = 0;
        for (Product product : order.products().keySet()) {
            if (productRepo.getAll().containsKey(product)) {
                if (productRepo.getSingle(product).getValue() >= order.products().get(product)) {
                    count++;
                }
            }
        }
        if (order.products().size() == count ) {
            System.out.println("Order fully received.");
            return true;
        }
        System.out.println("Ordered Products not available.");
        return false;
    }

    public OrderRepo getOrderRepo() {
        return orderRepo;
    }

    public ProductRepo getProductRepo () {
        return productRepo;
    }
}
