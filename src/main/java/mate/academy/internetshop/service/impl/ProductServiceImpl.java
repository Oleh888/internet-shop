package mate.academy.internetshop.service.impl;

import java.util.List;
import mate.academy.internetshop.dao.ProductDao;
import mate.academy.internetshop.lib.Inject;
import mate.academy.internetshop.lib.Service;
import mate.academy.internetshop.model.Product;
import mate.academy.internetshop.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
    @Inject
    private ProductDao productDao;

    @Override
    public Product create(Product product) {
        return productDao.create(product);
    }

    @Override
    public Product getProduct(Long id) {
        return productDao.getProduct(id).get();
    }

    @Override
    public Product update(Product product) {
        return productDao.update(product);
    }

    @Override
    public boolean deletedById(Long id) {
        return productDao.deletedById(id);
    }

    @Override
    public List<Product> getAll() {
        return productDao.getAll();
    }
}
