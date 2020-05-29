package dev.internetshop.security;

import dev.internetshop.exceptions.AuthenticationException;
import dev.internetshop.lib.Inject;
import dev.internetshop.lib.Service;
import dev.internetshop.model.User;
import dev.internetshop.service.UserService;
import dev.internetshop.util.HashUtil;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    @Inject
    private UserService userService;

    @Override
    public User login(String login, String password) throws AuthenticationException {
        User userFromDB = userService.findByLogin(login).orElseThrow(() ->
                new AuthenticationException("Incorrect username or password!"));
        if (isValid(userFromDB, password)) {
            return userFromDB;
        }
        throw new AuthenticationException("Incorrect username or password!");
    }

    private boolean isValid(User user, String password) {
        return HashUtil.hashPassword(password, user.getSalt()).equals(user.getPassword());
    }
}
