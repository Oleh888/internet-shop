package mate.academy.internetshop.service.impl;

import mate.academy.internetshop.dao.ProductDao;
import mate.academy.internetshop.dao.ShoppingCartDao;
import mate.academy.internetshop.lib.Inject;
import mate.academy.internetshop.lib.Service;
import mate.academy.internetshop.model.Product;
import mate.academy.internetshop.model.ShoppingCart;
import mate.academy.internetshop.service.ShoppingCardService;

@Service
public class ShoppingCartServiceImpl implements ShoppingCardService {
    @Inject
    ShoppingCartDao shoppingCartDao;
    @Inject
    ProductDao productDao;

    @Override
    public ShoppingCart addProduct(Long shoppingCartId, Long productId) {
        ShoppingCart shoppingCart = shoppingCartDao.get(shoppingCartId).get();
        Product product = productDao.getProduct(productId).get();
        shoppingCart.getProducts().add(product);
        return shoppingCartDao.update(shoppingCart);
    }
}
