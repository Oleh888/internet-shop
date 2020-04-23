package mate.academy.internetshop.model;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private User user;
    private List<Product> products;
    private Long id;

    public Order(User user) {
        this.user = user;
        products = new ArrayList<>();
    }

    public Long getOrderId() {
        return id;
    }

    public void setOrderId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
