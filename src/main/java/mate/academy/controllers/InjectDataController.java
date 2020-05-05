package mate.academy.controllers;

import java.io.IOException;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mate.academy.lib.Injector;
import mate.academy.model.Product;
import mate.academy.model.Role;
import mate.academy.model.User;
import mate.academy.service.ProductService;
import mate.academy.service.UserService;

public class InjectDataController extends HttpServlet {
    private static final Injector INJECTOR = Injector.getInstance("mate.academy");
    private UserService userService = (UserService) INJECTOR.getInstance(UserService.class);
    private ProductService productService =
            (ProductService) INJECTOR.getInstance(ProductService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        User oleh = new User("Oleh", "oleh888", "1111");
        oleh.setRoles(Set.of(Role.of("USER")));
        userService.create(oleh);
        User max = new User("Max", "maxim95", "1111");
        max.setRoles(Set.of(Role.of("USER")));
        userService.create(max);
        User admin = new User("admin", "admin", "1");
        admin.setRoles(Set.of(Role.of("ADMIN")));
        userService.create(admin);
        productService.create(new Product("Phone", 15000));
        productService.create(new Product("Car", 150000));
        req.getRequestDispatcher("/WEB-INF/views/injectData.jsp").forward(req, resp);
    }
}
