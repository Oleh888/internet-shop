package dev.internetshop.dao.jdbc;

import dev.internetshop.dao.ShoppingCartDao;
import dev.internetshop.exceptions.DataProcessingException;
import dev.internetshop.lib.Dao;
import dev.internetshop.lib.Injector;
import dev.internetshop.model.Product;
import dev.internetshop.model.ShoppingCart;
import dev.internetshop.service.UserService;
import dev.internetshop.util.ConnectionUtil;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Dao
public class ShoppingCartDaoJdbcImpl implements ShoppingCartDao {
    private static final Injector INJECTOR = Injector.getInstance("dev.internetshop");
    private UserService userService =
            (UserService) INJECTOR.getInstance(UserService.class);

    @Override
    public ShoppingCart create(ShoppingCart shoppingCart) {
        String query = "INSERT INTO shopping_carts(user_id) values(?)";
        try (Connection connection = ConnectionUtil.getConnection()) {
            PreparedStatement statement = connection
                    .prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setLong(1, shoppingCart.getUser().getUserId());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            while (resultSet.next()) {
                shoppingCart.setId(resultSet.getLong("GENERATED_KEY"));
            }
            return shoppingCart;
        } catch (SQLException e) {
            throw new DataProcessingException("Can't create shopping cart", e);
        }
    }

    @Override
    public Optional<ShoppingCart> get(Long id) {
        String query = "SELECT * FROM shopping_carts WHERE cart_id = ?";
        try (Connection connection = ConnectionUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                return Optional.of(getCartFromResultSet(resultSet));
            }
            return Optional.empty();
        } catch (SQLException e) {
            throw new DataProcessingException("Can't get shopping cart with id = " + id, e);
        }
    }

    @Override
    public List<ShoppingCart> getAll() {
        List<ShoppingCart> shoppingCarts = new ArrayList<>();
        String query = "SELECT * FROM shopping_carts";
        try (Connection connection = ConnectionUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                shoppingCarts.add(getCartFromResultSet(resultSet));
            }
            return shoppingCarts;
        } catch (SQLException e) {
            throw new DataProcessingException("Can't get a shopping cart list", e);
        }
    }

    @Override
    public ShoppingCart update(ShoppingCart shoppingCart) {
        deleteFromCart(shoppingCart.getId());
        addProductsToCart(shoppingCart);
        return shoppingCart;
    }

    @Override
    public boolean delete(Long id) {
        deleteFromCart(id);
        String query = "DELETE FROM shopping_carts WHERE cart_id = ?";
        try (Connection connection = ConnectionUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1, id);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new DataProcessingException("Can't delete shopping cart with id = " + id, e);
        }
    }

    private void addProductsToCart(ShoppingCart shoppingCart) {
        try (Connection connection = ConnectionUtil.getConnection()) {
            String query = "INSERT INTO shopping_carts_products(cart_id, product_id) "
                    + "values(?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            for (Product product : shoppingCart.getProducts()) {
                statement.setLong(1, shoppingCart.getId());
                statement.setLong(2, product.getId());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new DataProcessingException("Can't add products to shopping cart", e);
        }
    }

    private void deleteFromCart(Long id) {
        try (Connection connection = ConnectionUtil.getConnection()) {
            String query = "DELETE FROM shopping_carts_products WHERE cart_id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DataProcessingException("Can't add products to shopping cart", e);
        }
    }

    private ShoppingCart getCartFromResultSet(ResultSet resultSet) throws SQLException {
        Long cartId = resultSet.getLong("cart_id");
        Long userId = resultSet.getLong("user_id");
        ShoppingCart shoppingCart = new ShoppingCart(userService.get(userId));
        shoppingCart.setId(cartId);
        shoppingCart.setProducts(getProductsOfCart(cartId));
        return shoppingCart;
    }

    private List<Product> getProductsOfCart(Long id) throws SQLException {
        String query = "SELECT products.product_id, products.product_name, products.price "
                + "FROM shopping_carts_products INNER JOIN products "
                + "ON shopping_carts_products.product_id = products.product_id "
                + "WHERE shopping_carts_products.cart_id = ?";
        List<Product> products = new ArrayList<>();
        Connection connection = ConnectionUtil.getConnection();
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setLong(1, id);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Long productId = resultSet.getLong("product_id");
            String name = resultSet.getString("product_name");
            BigDecimal price = resultSet.getBigDecimal("price");
            Product product = new Product(name, price.doubleValue());
            product.setId(productId);
            products.add(product);
        }
        return products;
    }

    @Override
    public ShoppingCart getByUserId(Long userId) {
        return getAll().stream()
                .filter(shoppingCart ->
                        shoppingCart.getUser().getUserId().equals(userId))
                .findFirst().orElseGet(() ->
                        create(new ShoppingCart(userService.get(userId))));
    }
}
