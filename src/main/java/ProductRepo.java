import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProductRepo {
    private final List<Product> products;

    public ProductRepo() {
        products = new ArrayList<>();
    }

    public ProductRepo(List<Product> products) {
        this.products = products;
    }

    public void add(Product product){
        products.add(product);
    }

    public void remove(Product product){
        products.remove(product);
    }

    public Product getSingle(String name) {
        for (Product product : products) {
            if (product.name().equals(name)) {
                return product;
            }
        }
        return null;
    }

    public List<Product> getAll() {
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
        return "ProductRepo{" +
                "products=" + products +
                '}';
    }
}
