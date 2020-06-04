package dev.internetshop.dao.impl;

import dev.internetshop.dao.ShoppingCartDao;
import dev.internetshop.db.Storage;
import dev.internetshop.lib.Injector;
import dev.internetshop.model.ShoppingCart;
import dev.internetshop.service.UserService;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

public class ShoppingCartDaoImpl implements ShoppingCartDao {
    private static final Injector INJECTOR = Injector.getInstance("dev.internetshop");
    private UserService userService =
            (UserService) INJECTOR.getInstance(UserService.class);

    @Override
    public ShoppingCart create(ShoppingCart shoppingCart) {
        Storage.addShoppingCart(shoppingCart);
        return shoppingCart;
    }

    @Override
    public Optional<ShoppingCart> get(Long id) {
        return Storage.shoppingCarts.stream()
                .filter(shoppingCart -> shoppingCart.getId().equals(id))
                .findFirst();
    }

    @Override
    public boolean delete(Long id) {
        return Storage.shoppingCarts.removeIf(shoppingCart -> shoppingCart.getId().equals(id));
    }

    @Override
    public List<ShoppingCart> getAll() {
        return Storage.shoppingCarts;
    }

    @Override
    public ShoppingCart update(ShoppingCart shoppingCart) {
        IntStream.range(0, Storage.shoppingCarts.size())
                .filter(i -> Storage.shoppingCarts.get(i).getId().equals(shoppingCart.getId()))
                .forEach(i -> Storage.shoppingCarts.set(i, shoppingCart));
        return shoppingCart;
    }

    @Override
    public ShoppingCart getByUserId(Long userId) {
        return getAll().stream()
                .filter(shoppingCart -> shoppingCart.getUser().getUserId().equals(userId))
                .findFirst().orElseGet(() -> create(new ShoppingCart(userService.get(userId))));
    }
}
