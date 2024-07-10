package order;

import product.Product;

import java.util.*;

public class OrderMapRepo implements OrderRepo {
    Map<UUID, Order> orders;

    public OrderMapRepo() {
        orders = new HashMap<>();
    }

    public OrderMapRepo(Map<UUID, Order> orders) {
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
    public void remove(UUID id) {
        orders.remove(id);
    }

    @Override
    public Order getSingle(UUID id) {
        return orders.get(id);
    }

    @Override
    public void modifySingle(UUID id, Product product, int newQuantity ) {
        orders.replace(id, orders.get(id).withQuantity(product, newQuantity));
    }

    @Override
    public List<Order> getAll() {
        return  orders.values().stream().toList();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderMapRepo that = (OrderMapRepo) o;
        return Objects.equals(orders, that.orders);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(orders);
    }

    @Override
    public String toString() {
        return "OrderMapRepo{" +
                "orders=" + orders +
                '}';
    }
}
