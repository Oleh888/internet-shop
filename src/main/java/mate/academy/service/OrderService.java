package mate.academy.service;

import java.util.List;
import mate.academy.model.Order;
import mate.academy.model.Product;
import mate.academy.model.User;

public interface OrderService extends GenericService<Order, Long> {

    Order completeOrder(List<Product> products, User user);

    List<Order> getUserOrders(User user);
}
