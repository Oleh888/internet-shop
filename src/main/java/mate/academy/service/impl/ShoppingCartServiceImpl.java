package mate.academy.service.impl;

import java.util.List;
import mate.academy.dao.ShoppingCartDao;
import mate.academy.lib.Inject;
import mate.academy.lib.Service;
import mate.academy.model.Product;
import mate.academy.model.ShoppingCart;
import mate.academy.service.ShoppingCartService;
import mate.academy.service.UserService;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    @Inject
    private ShoppingCartDao shoppingCartDao;

    @Inject
    private UserService userService;

    @Override
    public ShoppingCart addProduct(ShoppingCart shoppingCart, Product product) {
        shoppingCart.getProducts().add(product);
        shoppingCartDao.update(shoppingCart);
        return shoppingCart;
    }

    @Override
    public boolean delete(ShoppingCart shoppingCart, Product product) {
        boolean result = shoppingCart.getProducts().remove(product);
        if (result) {
            shoppingCartDao.update(shoppingCart);
        }
        return result;
    }

    @Override
    public void clear(ShoppingCart shoppingCart) {
        shoppingCart.getProducts().clear();
        shoppingCartDao.update(shoppingCart);
    }

    @Override
    public ShoppingCart get(Long userId) {
        return shoppingCartDao.getAll().stream()
                .filter(shoppingCart -> shoppingCart.getUser().getUserId().equals(userId))
                .findFirst().orElseGet(() -> shoppingCartDao
                        .create(new ShoppingCart(userService.get(userId))));
    }

    @Override
    public List<Product> getAll(ShoppingCart shoppingCart) {
        return shoppingCart.getProducts();
    }
}
