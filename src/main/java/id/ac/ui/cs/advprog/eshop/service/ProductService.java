package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Product;
import java.util.List;

public interface ProductService {
    Product create(Product product);
    List<Product>findAll();
    Product edit(String productId, Product newProductData);
    Product findById(String productId);
    void delete(String productId);
}
