package order;

import product.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

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
    public void remove(UUID id) {
        orders.removeIf(order -> order.id().equals(id));
    }

    @Override
    public Order getSingle(UUID id) {
        for (Order order : orders) {
            if (order.id().equals(id)) {
                return order;
            }
        }
        return null;
    }

    @Override
    public void modifySingle(UUID id, Product product, int newQuantity ) {
        for (Order order : orders) {
            if (order.id().equals(id)) {
                orders.remove(order);
                orders.add(order.withQuantity(product, newQuantity));
            }
        }
    }

    @Override
    public List<Order> getAll() {
        return orders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderListRepo that = (OrderListRepo) o;
        return Objects.equals(orders, that.orders);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(orders);
    }

    @Override
    public String toString() {
        return "OrderListRepo{" +
                "orders=" + orders +
                '}';
    }
}
