package mate.academy.internetshop;

import java.util.List;
import mate.academy.internetshop.lib.Injector;
import mate.academy.internetshop.model.Product;
import mate.academy.internetshop.service.ProductService;

public class Application {
    private static Injector injector = Injector.getInstance("mate.academy.internetshop");

    public static void main(String[] args) {
        ProductService productService = (ProductService) injector.getInstance(ProductService.class);
        initializedDb(productService);
        List<Product> allProducts = productService.getAll();
        for (Product product : allProducts) {
            System.out.println(product.toString());
        }
    }

    public static void initializedDb(ProductService productService) {
        Product product1 = new Product("BMV", 70_0000);
        Product product2 = new Product("Audi", 77_000);
        Product product3 = new Product("Lanos", 10_000);
        productService.create(product1);
        productService.create(product2);
        productService.create(product3);
    }
}
