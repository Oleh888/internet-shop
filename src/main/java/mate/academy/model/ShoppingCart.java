package mate.academy.model;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Product> products;
    private Long id;
    private User user;

    public ShoppingCart(User user) {
        this.user = user;
        products = new ArrayList<>();
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ShoppingCart{" + "products=" + products + ", id=" + id + ", user=" + user + '}';
    }
}
