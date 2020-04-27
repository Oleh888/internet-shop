package mate.academy.service;

import java.util.List;
import mate.academy.model.Product;
import mate.academy.model.ShoppingCart;

public interface ShoppingCartService {

    ShoppingCart addProduct(ShoppingCart shoppingCart, Product product);

    boolean delete(ShoppingCart shoppingCart, Product product);

    void clear(ShoppingCart shoppingCart);

    List<Product> getAll(ShoppingCart shoppingCart);

    ShoppingCart get(Long userId);
}
