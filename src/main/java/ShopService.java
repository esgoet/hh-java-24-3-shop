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

    public boolean isOrderAvailable(Order order) {
        int count = 0;
        for (Product product : order.products()) {
            if (productRepo.getAll().contains(product)) {
                count++;
            }
        }
        if (order.products().size() == count ) {
            return true;
        }
        System.out.println("Ordered Products not available.");
        return false;
    }

}
