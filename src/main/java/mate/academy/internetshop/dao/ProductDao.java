package mate.academy.internetshop.dao;

import java.util.List;
import java.util.Optional;
import mate.academy.internetshop.model.Product;

public interface ProductDao {

    Product create(Product product);

    Optional<Product> getProduct(Long id);

    Product update(Product product);

    boolean deletedById(Long id);

    boolean deletedByProduct(Product product);

    List<Product> getAll();
}
