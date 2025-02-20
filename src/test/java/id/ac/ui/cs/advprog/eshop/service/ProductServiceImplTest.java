package id.ac.ui.cs.advprog.eshop.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import id.ac.ui.cs.advprog.eshop.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import id.ac.ui.cs.advprog.eshop.model.Product;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {

    @Mock
    ProductRepository productRepository;

    @InjectMocks
    ProductServiceImpl productService;

    Product product;

    @BeforeEach
    void setUp() {
        this.product = new Product();
        this.product.setProductId("Sampo Cap Bambang");
        this.product.setProductQuantity(100);
    }

    @Test
    void testCreateAndFindProduct() {
        when(productRepository.create(product)).thenReturn(product);
        productService.create(product);

        when(productRepository.findAll()).thenReturn(List.of(product).iterator());
        Iterator<Product> productIterator = productService.findAll().iterator();

        assertTrue(productIterator.hasNext());
        Product savedProduct = productIterator.next();
        assertEquals(product.getProductId(), savedProduct.getProductId());
        assertEquals(product.getProductName(), savedProduct.getProductName());
        assertEquals(product.getProductQuantity(), savedProduct.getProductQuantity());
    }

    @Test
    void testFindAll() {
        Product product1 = new Product();
        product1.setProductId("111");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(100);

        Product product2 = new Product();
        product2.setProductId("222");
        product2.setProductName("Sampo Cap Usep");
        product2.setProductQuantity(50);

        List<Product> productList = Arrays.asList(product1, product2);
        Iterator<Product> productIterator = productList.iterator();

        when(productRepository.findAll()).thenReturn(productIterator);

        List<Product> result = productService.findAll();

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(product1, result.get(0));
        assertEquals(product2, result.get(1));
    }

    @Test
    void testEdit() {
        when(productRepository.edit(product.getProductId(), product)).thenReturn(product);
        Product updatedProduct = productService.edit(product.getProductId(), product);

        assertEquals(product, updatedProduct);
    }

    @Test
    void testFindProductById() {
        when(productRepository.findById("eb558e9f-1c39-460e-8860-71af6af63bd6")).thenReturn(product);
        Product savedProduct = productService.findById("eb558e9f-1c39-460e-8860-71af6af63bd6");

        assertEquals(product, savedProduct);
    }

    @Test
    void testDelete() {
        productService.delete(product.getProductId());
        Mockito.verify(productRepository).delete(product.getProductId());
    }
}
