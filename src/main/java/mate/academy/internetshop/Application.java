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

        Product car = new Product("BMV", 70_000);
        Product phone = new Product("Iphone", 10_000);
        Product car2 = new Product("lanos", 8_000);

        productService.create(car);
        productService.create(car2);
        productService.create(phone);

        System.out.println("Товари " + productService.getAll() + "\n");

        User oleh = new User("Oleh", "olehOleh", "parol");
        User dima = new User("Dmitro", "dimas", "parol");

        userService.create(oleh);
        userService.create(dima);
        System.out.println("Користувачі" + userService.getAll() + "\n");

        ShoppingCart shoppingCartOleh = new ShoppingCart(oleh);
        ShoppingCart shoppingCartDima = new ShoppingCart(dima);
        shoppingCartService.addProduct(shoppingCartDima, car);
        shoppingCartService.addProduct(shoppingCartDima, phone);
        shoppingCartService.addProduct(shoppingCartOleh, car2);
        System.out.println("Товари Дмитра " + shoppingCartService.getAllProducts(shoppingCartDima) + "\n");
        shoppingCartService.clear(shoppingCartDima);
        System.out.println("Використав метод clear " + shoppingCartService.getAllProducts(shoppingCartDima) + "\n");
        shoppingCartService.addProduct(shoppingCartDima, car);

        orderService.completeOrder(shoppingCartDima.getProducts(), dima);
        orderService.completeOrder(shoppingCartOleh.getProducts(), oleh);
        System.out.println("Замовлення Дмитра " + orderService.getUserOrders(dima) + "\n");
    }
}
