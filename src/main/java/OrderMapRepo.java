import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderMapRepo implements OrderRepo {
    Map<String, Order> orders;

    public OrderMapRepo() {
        orders = new HashMap<>();
    }

    public OrderMapRepo(Map<String, Order> orders) {
        this.orders = orders;
    }

    @Override
    public void add(Order order) {
        orders.put(order.id(), order);
    }

    @Override
    public void remove(Order order) {
        orders.remove(order.id());

    }

    @Override
    public void remove(String id) {
        orders.remove(id);
    }

    @Override
    public Order getSingle(String id) {
        return orders.get(id);
    }

    @Override
    public List<Order> getAll() {
        return  orders.values().stream().toList();
    }
}
