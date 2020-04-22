package mate.academy.internetshop.dao;

import java.util.Optional;
import mate.academy.internetshop.model.ShoppingCart;

public interface ShoppingCartDao {

    ShoppingCart create(ShoppingCart shoppingCart);

    Optional<ShoppingCart> get(Long bucketId);

    ShoppingCart update(ShoppingCart shoppingCart);
}
