package dev.internetshop.dao;

import dev.internetshop.model.Order;
import dev.internetshop.model.User;
import java.util.List;

public interface OrderDao extends GenericDao<Order, Long> {
    List<Order> getUserOrders(User user);
}
