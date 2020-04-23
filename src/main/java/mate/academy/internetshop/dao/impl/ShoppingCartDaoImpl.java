package mate.academy.internetshop.dao.impl;

import java.util.List;
import mate.academy.internetshop.dao.ShoppingCartDao;
import mate.academy.internetshop.db.Storage;
import mate.academy.internetshop.lib.Dao;
import mate.academy.internetshop.model.Product;
import mate.academy.internetshop.model.ShoppingCart;

@Dao
public class ShoppingCartDaoImpl implements ShoppingCartDao {

    @Override
    public ShoppingCart addProduct(ShoppingCart shoppingCart, Product product) {
        shoppingCart.getProducts().add(product);
        Storage.addShoppingCart(shoppingCart);
        Storage.addUser(shoppingCart.getUser());
        return shoppingCart;
    }

    @Override
    public boolean deleteProduct(ShoppingCart shoppingCart, Product product) {
        return shoppingCart.getProducts().remove(product);
    }

    @Override
    public void clear(ShoppingCart shoppingCart) {
        shoppingCart.getProducts().clear();
    }

    @Override
    public ShoppingCart getByUserId(Long userId) {
        return Storage.shoppingCarts
                .stream()
                .filter(shoppingCart -> shoppingCart.getUser().getUserId().equals(userId))
                .findFirst().get();
    }

    @Override
    public List<Product> getAllProducts(ShoppingCart shoppingCart) {
        return Storage.shoppingCarts
                .stream()
                .filter(shoppingCart1 -> shoppingCart1.equals(shoppingCart))
                .findFirst()
                .get()
                .getProducts();
    }
}
