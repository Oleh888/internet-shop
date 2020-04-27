package mate.academy.service;

import mate.academy.model.Product;

public interface ProductService extends GenericService<Product, Long> {

    Product create(Product product);

    Product update(Product product);
}
