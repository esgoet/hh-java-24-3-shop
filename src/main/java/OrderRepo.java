import java.util.List;

public interface OrderRepo {
    void add(Order order);
    void remove(Order order);
    void remove(String id);
    Order getSingle(String id);
    List<Order> getAll();
}
