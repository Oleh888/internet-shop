package mate.academy.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mate.academy.lib.Injector;
import mate.academy.model.Product;
import mate.academy.model.ShoppingCart;
import mate.academy.service.ProductService;
import mate.academy.service.ShoppingCartService;

public class AddProductToShoppingCartController extends HttpServlet {
    private static final Long USER_ID = 1L;
    private static final Injector INJECTOR = Injector.getInstance("mate.academy");
    private ShoppingCartService shoppingCartService =
            (ShoppingCartService) INJECTOR.getInstance(ShoppingCartService.class);
    private ProductService productService =
            (ProductService) INJECTOR.getInstance(ProductService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        ShoppingCart shoppingCart = shoppingCartService.get(USER_ID);
        String productId = req.getParameter("id");
        Product product = productService.get(Long.valueOf(productId));
        shoppingCartService.addProduct(shoppingCart, product);
        req.getRequestDispatcher("/WEB-INF/views/products/all.jsp").forward(req, resp);
    }
}
