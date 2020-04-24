package mate.academy.internetshop.service;

import java.util.List;
import mate.academy.internetshop.model.Product;

public interface ProductService {

    Product create(Product product);

    Product getProduct(Long id);

    Product update(Product product);

    boolean deletedById(Long id);

    List<Product> getAll();
}
