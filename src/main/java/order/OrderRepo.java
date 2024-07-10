package order;

import product.Product;

import java.util.List;
import java.util.UUID;

public interface OrderRepo {
    void add(Order order);
    void remove(Order order);
    void remove(UUID id);
    Order getSingle(UUID id);
    void modifySingle(UUID id, Product product, int newQuantity );
    List<Order> getAll();
}
