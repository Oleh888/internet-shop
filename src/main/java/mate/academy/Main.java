package mate.academy;

import mate.academy.lib.Injector;
import mate.academy.service.OrderService;
import mate.academy.service.ProductService;
import mate.academy.service.ShoppingCartService;
import mate.academy.service.UserService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.academy");

    public static void main(String[] args) {
        ProductService productService =
                (ProductService) injector.getInstance(ProductService.class);
        UserService userService =
                (UserService) injector.getInstance(UserService.class);
        ShoppingCartService shoppingCartService =
                (ShoppingCartService) injector.getInstance(ShoppingCartService.class);
        OrderService orderService =
                (OrderService) injector.getInstance(OrderService.class);
    }
}
