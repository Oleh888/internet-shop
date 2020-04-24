package mate.academy.internetshop;

import mate.academy.internetshop.lib.Injector;
import mate.academy.internetshop.model.Order;
import mate.academy.internetshop.model.Product;
import mate.academy.internetshop.model.ShoppingCart;
import mate.academy.internetshop.model.User;
import mate.academy.internetshop.service.OrderService;
import mate.academy.internetshop.service.ProductService;
import mate.academy.internetshop.service.ShoppingCartService;
import mate.academy.internetshop.service.UserService;

public class Application {
    private static Injector injector = Injector.getInstance("mate.academy.internetshop");

    public static void main(String[] args) {
        ProductService productService =
                (ProductService) injector.getInstance(ProductService.class);
        UserService userService =
                (UserService) injector.getInstance(UserService.class);
        ShoppingCartService shoppingCartService =
                (ShoppingCartService) injector.getInstance(ShoppingCartService.class);
        OrderService orderService =
                (OrderService) injector.getInstance(OrderService.class);

        Product product1 = new Product("BMV", 70_000);
        Product product2 = new Product("Lanos", 10_000);
        productService.create(product1);
        productService.create(product2);

        System.out.println(productService.getProduct(product1.getId()));
        System.out.println(productService.getAll());

        Product product3 = new Product("Audi", 80_000);
        productService.create(product3);
        productService.deletedById(product2.getId());
        product1.setPrice(50_000);
        System.out.println(productService.getAll() + "\n");

        User user1 = new User("Oleh", "oleh8", "8888");
        User user2 = new User("Anton", "antonAnton", "parol");
        userService.create(user1);
        userService.create(user2);
        System.out.println(userService.getAll());
        user2.setLogin("anton!");
        System.out.println(userService.getAll());
        userService.delete(user2.getUserId());
        System.out.println(userService.getAll() + "\n");
        userService.create(user2);

        ShoppingCart user1Cart = shoppingCartService.getByUserId(user1.getUserId());
        ShoppingCart user2Cart = shoppingCartService.getByUserId(user2.getUserId());
        shoppingCartService.addProduct(user1Cart, product1);
        shoppingCartService.addProduct(user1Cart, product2);
        shoppingCartService.addProduct(user2Cart, product2);
        shoppingCartService.addProduct(user2Cart, product3);
        System.out.println(shoppingCartService.getAllProducts(user2Cart) + "\n");

        Order userOneOrder = orderService.completeOrder(shoppingCartService.getAllProducts(user1Cart), user1);
        System.out.println(shoppingCartService.getByUserId(user1.getUserId()));
        System.out.println(orderService.get(userOneOrder.getOrderId()));
        System.out.println(orderService.getUserOrders(user1));
        userService.create(user2);
        productService.create(product3);
        ShoppingCart userTwoCart = shoppingCartService.getByUserId(user2.getUserId());
        shoppingCartService.addProduct(userTwoCart, product2);
        Order userTwoOrder = orderService.completeOrder(shoppingCartService.getAllProducts(user1Cart), user2);
        System.out.println(orderService.getAll());
        orderService.delete(userTwoOrder.getOrderId());
        System.out.println(orderService.getAll());
    }
}
