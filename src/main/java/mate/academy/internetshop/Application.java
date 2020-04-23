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
        ProductService productService = (ProductService) injector.getInstance(ProductService.class);
        Product product1 = new Product("BMV", 70_0000);
        productService.create(product1);

        UserService userService = (UserService) injector.getInstance(UserService.class);
        User user1 = new User("Oleh");
        initializedUsers(userService, user1);

        ShoppingCartService shoppingCartService = (ShoppingCartService)
                injector.getInstance(ShoppingCartService.class);
        ShoppingCart shoppingCart1 = new ShoppingCart(user1);
        initializedShoppingCart(shoppingCartService, shoppingCart1, product1);
        shoppingCartService.addProduct(shoppingCart1, product1);

        OrderService orderService = (OrderService) injector.getInstance(OrderService.class);
        initializedOrder(orderService, shoppingCart1);
    }

    public static void initializedUsers(UserService service, User user) {
        System.out.println("Before creating " + user);
        System.out.println("After creating " + service.create(user));
        System.out.println("Get user by ID " + service.get(user.getUserId()));
        System.out.println("After updating info " + service
                .update(service.create(new User("Anton"))));
        System.out.println("All users " + service.getAll());
        System.out.println("Delete user " + service.delete(user.getUserId()));
        System.out.println();
    }

    public static void initializedShoppingCart(ShoppingCartService shCartServ,
                                               ShoppingCart shCart, Product pr) {
        System.out.println("Before adding product " + shCart);
        System.out.println("After adding product " + shCartServ.addProduct(shCart, pr));
        System.out.println("Get shCart by userId " + shCartServ
                .getByUserId(shCart.getUser().getUserId()));
        System.out.println("All products " + shCartServ.getAllProducts(shCart));
        System.out.println("Delete shoppingCart " + shCartServ.deleteProduct(shCart, pr));
        System.out.println();
    }

    public static void initializedOrder(OrderService orderService, ShoppingCart shCart) {
        Order order = orderService.completeOrder(shCart.getProducts(), shCart.getUser());
        System.out.println("Completed order + " + order);
        System.out.println("Get order by ID " + orderService.get(order.getOrderId()));
        System.out.println("All orders " + orderService.getAll());
        Order order1 = new Order(order.getUser());
        System.out.println("New order with the same user " + order1);
        System.out.println("Completed new order " + orderService
                .completeOrder(order.getProducts(), order1.getUser()));
        System.out.println("All user's orders " + orderService.getUserOrders(order.getUser()));
        System.out.println(orderService.delete(order.getOrderId()));
    }
}
