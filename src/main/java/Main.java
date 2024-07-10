public class Main {
    public static void main(String[] args) {
        OrderMapRepo orderRepo = new OrderMapRepo();
        ProductRepo productRepo = new ProductRepo();
        ShopService shopService = new ShopService(orderRepo, productRepo);
    }
}
