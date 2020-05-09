package mate.academy.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import mate.academy.dao.ProductDao;
import mate.academy.exceptions.DataProcessingException;
import mate.academy.lib.Dao;
import mate.academy.model.Product;
import mate.academy.util.ConnectionUtil;

@Dao
public class ProductDaoJdbcImpl implements ProductDao {
    private static final int ID_COLUMN = 1;

    @Override
    public Product create(Product product) {
        String sqlInsert = "INSERT INTO products (product_name, price) VALUES (?, ?)";
        try (Connection connection = ConnectionUtil.getConnection()) {
            PreparedStatement statement = connection
                    .prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, product.getName());
            statement.setBigDecimal(2, product.getPrice());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            while (resultSet.next()) {
                product.setId(resultSet.getLong(ID_COLUMN));
            }
            return product;
        } catch (SQLException e) {
            throw new DataProcessingException("Can't INSERT INTO products in DB", e);
        }
    }

    @Override
    public Optional<Product> get(Long id) {
        String sqlGet = "SELECT * FROM products WHERE product_id = ?";
        try (Connection connection = ConnectionUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sqlGet);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Product product = new Product(resultSet.getString("product_name"),
                            resultSet.getDouble("price"));
                product.setId(id);
                return Optional.of(product);
            }
        } catch (SQLException e) {
            throw new DataProcessingException("Can't SELECT product in DB with id: " + id, e);
        }
        return Optional.empty();
    }

    @Override
    public List<Product> getAll() {
        List<Product> products = new ArrayList<>();
        String sqlGetAll = "SELECT * FROM products";
        try (Connection connection = ConnectionUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sqlGetAll);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Product product = new Product(resultSet.getString("product_name"),
                        resultSet.getDouble("price"));
                product.setId(resultSet.getLong("product_id"));
                products.add(product);
            }
            return products;
        } catch (SQLException e) {
            throw new DataProcessingException("Can't SELECT * FROM products in DB", e);
        }
    }

    @Override
    public Product update(Product product) {
        String sqlUpdate = "UPDATE products SET product_name = ?, price = ? WHERE (product_id = ?)";
        try (Connection connection = ConnectionUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sqlUpdate);
            statement.setString(1, product.getName());
            statement.setBigDecimal(2, product.getPrice());
            statement.setLong(3, product.getId());
            statement.executeUpdate();
            return product;
        } catch (SQLException e) {
            throw new DataProcessingException("Can't UPDATE products in DB", e);
        }
    }

    @Override
    public boolean delete(Long id) {
        String sqlDelete = "DELETE FROM products WHERE product_id = ?";
        try (Connection connection = ConnectionUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sqlDelete);
            statement.setLong(1, id);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new DataProcessingException("Can't DELETE product in DB with id: " + id, e);
        }
    }
}
