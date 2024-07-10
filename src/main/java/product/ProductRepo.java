package product;

import java.util.*;

public class ProductRepo {
    private final Map<Product, Integer> products;

    public ProductRepo() {
        products = new HashMap<>();
    }

    public ProductRepo(Map<Product, Integer> products) {
        this.products = products;
    }

    public void add(Product product){
        products.compute(product, (k, v) -> (v == null) ? 1 : v + 1);
    }

    public void remove(Product product){
        products.remove(product);
    }

    public Map.Entry<Product, Integer> getSingle(Product product) {
        if (products.get(product) != null) {
            return Map.entry(product, products.get(product));
        }
        return null;
    }

    public Map<Product, Integer> getAll() {
        return products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductRepo that = (ProductRepo) o;
        return Objects.equals(products, that.products);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(products);
    }

    @Override
    public String toString() {
        return "product.ProductRepo{" +
                "products=" + products +
                '}';
    }
}
