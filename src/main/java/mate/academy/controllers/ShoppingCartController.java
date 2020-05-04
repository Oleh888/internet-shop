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
import mate.academy.service.ShoppingCartService;

public class GetShoppingCartController extends HttpServlet {
    private static final Injector INJECTOR = Injector.getInstance("mate.academy");
    private ShoppingCartService shoppingCartService =
            (ShoppingCartService) INJECTOR.getInstance(ShoppingCartService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Long userId = (Long) req.getSession().getAttribute("user_id");
        ShoppingCart shoppingCart = shoppingCartService.getByUserId(userId);
        List<Product> productList = shoppingCart.getProducts();
        req.setAttribute("products", shoppingCart.getProducts());
        req.getRequestDispatcher("/WEB-INF/views/carts/all.jsp").forward(req, resp);
    }
}
