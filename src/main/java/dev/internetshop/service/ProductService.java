package dev.internetshop.service;

import dev.internetshop.model.Product;

public interface ProductService extends GenericService<Product, Long> {

    Product create(Product product);

    Product update(Product product);
}
