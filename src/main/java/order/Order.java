package order;

import product.Product;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public record Order(
        LocalDate date,
        UUID id,
        Map<Product, Integer> products
) {
    public Order(Map<Product, Integer> products) {
        this(LocalDate.now(), UUID.randomUUID(), products);
    }

    public Order withQuantity(Product product, int newQuantity) {
        Map<Product, Integer> newProducts = new HashMap<>(Map.copyOf(products));
        newProducts.replace(product, newQuantity);
        return new Order(newProducts);
    }

    public double getTotalPrice() {
        double totalPrice = 0;
        for (Product product : products.keySet()){
            totalPrice += product.price() * products.get(product);
        }
        return totalPrice;
    }
}
