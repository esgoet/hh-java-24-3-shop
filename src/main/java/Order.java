import java.util.Date;
import java.util.List;

public record Order(
        Date date,
        String id,
        List<Product> products
) {
}
