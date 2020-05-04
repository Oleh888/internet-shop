package mate.academy.controllers;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mate.academy.lib.Injector;
import mate.academy.model.Order;
import mate.academy.model.Product;
import mate.academy.service.OrderService;

public class GetAllOrderController extends HttpServlet {
    private static final Injector INJECTOR = Injector.getInstance("mate.academy");
    private OrderService orderService =
            (OrderService) INJECTOR.getInstance(OrderService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String orderId = req.getParameter("id");
        Order order = orderService.get(Long.valueOf(orderId));
        List<Product> productList = order.getProducts();
        req.setAttribute("products", productList);
        req.getRequestDispatcher("/WEB-INF/views/orders/products.jsp").forward(req, resp);
    }
}
