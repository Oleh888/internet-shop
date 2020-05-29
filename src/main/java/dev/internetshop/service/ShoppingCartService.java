package dev.internetshop.service;

import dev.internetshop.model.Product;
import dev.internetshop.model.ShoppingCart;
import java.util.List;

public interface ShoppingCartService {

    ShoppingCart addProduct(ShoppingCart shoppingCart, Product product);

    boolean deleteProduct(ShoppingCart shoppingCart, Product product);

    void clear(ShoppingCart shoppingCart);

    List<Product> getAll(ShoppingCart shoppingCart);

    ShoppingCart getByUserId(Long userId);
}
