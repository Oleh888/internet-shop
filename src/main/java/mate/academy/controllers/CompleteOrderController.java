package mate.academy.controllers;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mate.academy.lib.Injector;
import mate.academy.model.Product;
import mate.academy.model.ShoppingCart;
import mate.academy.service.OrderService;
import mate.academy.service.ShoppingCartService;
import mate.academy.service.UserService;

public class CompleteOrderController extends HttpServlet {
    private static final Injector INJECTOR = Injector.getInstance("mate.academy");
    private OrderService orderService =
            (OrderService) INJECTOR.getInstance(OrderService.class);
    private ShoppingCartService shoppingCartService =
            (ShoppingCartService) INJECTOR.getInstance(ShoppingCartService.class);
    private UserService userService =
            (UserService) INJECTOR.getInstance(UserService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Long userId = (Long) req.getSession().getAttribute("user_id");
        ShoppingCart shoppingCart = shoppingCartService.getByUserId(userId);
        List<Product> products = shoppingCart.getProducts();
        orderService.completeOrder(products, userService.get(userId));
        shoppingCartService.clear(shoppingCart);
        resp.sendRedirect(req.getContextPath() + "/shoppingCart/all");
    }
}
