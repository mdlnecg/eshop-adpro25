package id.ac.ui.cs.advprog.eshop.controller;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.service.ProductServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
class ProductControllerTest {

    @BeforeEach
    void setUp() {

    }

    @InjectMocks
    ProductController productController;

    @Mock
    ProductServiceImpl productService;
    Model model = mock(Model.class);
    Product product = new Product();

    @Test
    void testCreateProductPage() {
        String result = productController.createProductPage(model);
        assertEquals("CreateProduct", result);
    }

    @Test
    void testCreateProductPost() {
        Mockito.when(productService.create(product)).thenReturn(product);
        String result = productController.createProductPost(product, model);
        assertEquals("redirect:list", result);
    }

    @Test
    void testProductListPage() {
        Mockito.when(productService.findAll()).thenReturn(null);
        String result = productController.productListPage(model);
        assertEquals("ProductList", result);
    }

    @Test
    void testEditProductPage() {
        Mockito.when(productService.findById("eb558e9f-1c39-460e-8860-71af6af63bd6")).thenReturn(product);
        String result = productController.editProductPage("eb558e9f-1c39-460e-8860-71af6af63bd6", model);
        assertEquals("EditProduct", result);
    }

    @Test
    void testEditProductPageIfNull() {
        String result = productController.editProductPage("505", model);
        assertEquals("redirect:/product/list", result);
    }

    @Test
    void testEditProductPost() {
        Mockito.when(productService.edit(product.getProductId(), product)).thenReturn(product);
        String result = productController.editProduct(product.getProductId(), product, model);
        assertEquals("redirect:/product/list", result);
    }

    @Test
    void testDeleteProduct() {
        String result = productController.deleteProduct("eb558e9f-1c39-460e-8860-71af6af63bd6", model);
        assertEquals("redirect:/product/list", result);
    }
}
