package mate.academy.db;

import java.util.ArrayList;
import java.util.List;
import mate.academy.model.Order;
import mate.academy.model.Product;
import mate.academy.model.ShoppingCart;
import mate.academy.model.User;

public class Storage {
    public static final List<Product> products = new ArrayList<>();
    public static final List<ShoppingCart> shoppingCarts = new ArrayList<>();
    public static final List<User> users = new ArrayList<>();
    public static final List<Order> orders = new ArrayList<>();
    private static Long userId = 0L;
    private static Long shoppingCartsId = 0L;
    private static Long orderId = 0L;
    private static Long productId = 0L;

    public static void addProduct(Product product) {
        productId++;
        product.setId(productId);
        products.add(product);
    }

    public static void addUser(User user) {
        userId++;
        user.setUserId(userId);
        users.add(user);
    }

    public static void addShoppingCart(ShoppingCart shoppingCart) {
        shoppingCartsId++;
        shoppingCart.setId(shoppingCartsId);
        shoppingCarts.add(shoppingCart);
    }

    public static void addOrder(Order order) {
        orderId++;
        order.setOrderId(orderId);
        orders.add(order);
    }
}
