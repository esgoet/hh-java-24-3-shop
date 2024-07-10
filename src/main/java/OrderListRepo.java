import java.util.ArrayList;
import java.util.List;

public class OrderListRepo implements OrderRepo {
    private final List<Order> orders;

    public OrderListRepo() {
        orders = new ArrayList<>();
    }

    public OrderListRepo(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public void add(Order order) {
        orders.add(order);
    }

    @Override
    public void remove(Order order) {
        orders.remove(order);
    }

    @Override
    public void remove(String id) {
        orders.removeIf(order -> order.id().equals(id));
    }

    @Override
    public Order getSingle(String id) {
        for (Order order : orders) {
            if (order.id().equals(id)) {
                return order;
            }
        }
        return null;
    }

    @Override
    public List<Order> getAll() {
        return orders;
    }
}
