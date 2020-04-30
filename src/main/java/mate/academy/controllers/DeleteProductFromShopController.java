package mate.academy.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mate.academy.lib.Injector;
import mate.academy.service.ProductService;

public class DeleteProductFromShopController extends HttpServlet {
    private static final Injector INJECTOR = Injector.getInstance("mate.academy");
    private ProductService productService =
            (ProductService) INJECTOR.getInstance(ProductService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String productId = req.getParameter("id");
        productService.delete(Long.valueOf(productId));
        resp.sendRedirect(req.getContextPath() + "/AllProductsForAdmin");
    }
}
