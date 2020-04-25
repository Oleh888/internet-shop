package mate.academy.service;

import java.util.List;
import mate.academy.model.Product;

public interface ProductService {

    Product create(Product product);

    Product getProduct(Long id);

    Product update(Product product);

    boolean deletedById(Long id);

    List<Product> getAll();
}
