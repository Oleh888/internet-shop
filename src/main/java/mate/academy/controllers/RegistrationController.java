package mate.academy.controllers;

import java.io.IOException;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mate.academy.lib.Injector;
import mate.academy.model.Role;
import mate.academy.model.User;
import mate.academy.service.UserService;
import org.apache.log4j.Logger;

public class RegistrationController extends HttpServlet {
    private static final Logger LOGGER = Logger.getLogger(RegistrationController.class);
    private static final Injector INJECTOR = Injector.getInstance("mate.academy");
    private UserService userService = (UserService) INJECTOR.getInstance(UserService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/users/registration.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String password = req.getParameter("pwd");
        String repeatPassword = req.getParameter("repeat-pwd");
        if (password.equals(repeatPassword)) {
            User user = new User(name, login, password);
            user.setRoles(Set.of(Role.of("USER")));
            userService.create(user);
            resp.sendRedirect(req.getContextPath() + "/");
        } else {
            LOGGER.info("User with the name " + name + " failed to provide matching passwords");
            req.setAttribute("message", "Your password and repeat password aren't the same!");
            req.getRequestDispatcher("/WEB-INF/views/users/registration.jsp").forward(req, resp);
        }
    }
}
