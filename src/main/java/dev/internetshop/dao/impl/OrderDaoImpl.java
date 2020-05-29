package dev.internetshop.dao.impl;

import dev.internetshop.dao.OrderDao;
import dev.internetshop.db.Storage;
import dev.internetshop.model.Order;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

public class OrderDaoImpl implements OrderDao {

    @Override
    public Order create(Order order) {
        Storage.addOrder(order);
        return order;
    }

    @Override
    public Optional<Order> get(Long id) {
        return Storage.orders.stream()
                .filter(order -> order.getOrderId().equals(id))
                .findFirst();
    }

    @Override
    public List<Order> getAll() {
        return Storage.orders;
    }

    @Override
    public Order update(Order order) {
        IntStream.range(0, Storage.orders.size())
                .filter(i -> Storage.orders.get(i).getOrderId().equals(order.getOrderId()))
                .forEach(i -> Storage.orders.set(i, order));
        return order;
    }

    @Override
    public boolean delete(Long id) {
        return Storage.orders.removeIf(order -> order.getOrderId().equals(id));
    }
}
