package product;

import java.util.*;

public class ProductRepo {
//    private final List<product.Product> products;
    private final Map<Product, Integer> products;

    public ProductRepo() {
//        products = new ArrayList<>();
        products = new HashMap<>();
    }

    public ProductRepo(Map<Product, Integer> products) {
        this.products = products;
    }

    public void add(Product product){
//        products.add(product);
        products.compute(product, (k, v) -> (v == null) ? 1 : v + 1);
    }

    public void remove(Product product){
        products.remove(product);
    }

    public Product getSingle(String name) {
        for (Product product : products.keySet()) {
            if (product.name().equals(name)) {
                return product;
            }
        }
        return null;
    }

    public Map<Product, Integer> getAll() {
//        return products;
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
