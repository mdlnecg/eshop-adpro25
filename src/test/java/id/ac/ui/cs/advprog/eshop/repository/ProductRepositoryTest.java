package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class ProductRepositoryTest {

    @InjectMocks
    ProductRepository productRepository;

    Product product;

    @BeforeEach
    void setUp() {
    }

    Product setProduct() {
        product = new Product();
        product.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(100);
        productRepository.create(product);
        return product;
    }

    @Test
    void testCreateAndFind() {
        Product product = setProduct();

        Iterator<Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());
        Product savedProduct = productIterator.next();
        assertEquals(product.getProductId(), savedProduct.getProductId());
        assertEquals(product.getProductName(), savedProduct.getProductName());
        assertEquals(product.getProductQuantity(), savedProduct.getProductQuantity());
    }

    @Test
    void testFindAllIfEmpty() {
        Iterator<Product> productIterator = productRepository.findAll();
        assertFalse(productIterator.hasNext());
    }

    @Test
    void testFindAllMoreThanOneProduct() {
        Product product1 = setProduct();

        Product product2 = new Product();
        product2.setProductId("a0f9de46-90b1-437d-a0bf-d0821dde9096");
        product2.setProductName("Sampo Cap Usep");
        product2.setProductQuantity(50);
        productRepository.create(product2);

        Iterator<Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());
        Product savedProduct = productIterator.next();
        assertEquals(product1.getProductId(), savedProduct.getProductId());
        savedProduct = productIterator.next();
        assertEquals(product2.getProductId(), savedProduct.getProductId());
        assertFalse(productIterator.hasNext());
    }


    @Test
    void testEditIfProductExists() {
        Product product = setProduct();

        Product updatedProduct = new Product();
        updatedProduct.setProductName("Sampo Cap Dadang");
        updatedProduct.setProductQuantity(50);
        productRepository.edit(product.getProductId(), updatedProduct);

        Iterator<Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());
        Product savedProduct = productIterator.next();
        assertEquals(updatedProduct.getProductName(), savedProduct.getProductName());
        assertEquals(updatedProduct.getProductQuantity(), savedProduct.getProductQuantity());
    }

    @Test
    void testEditIfProductDoesNotExist() {
        Product updatedProduct = new Product();
        updatedProduct.setProductName("Sampo Cap Ujang");
        updatedProduct.setProductQuantity(25);

        productRepository.edit("non-existent-id", updatedProduct);

        Iterator<Product> productIterator = productRepository.findAll();
        assertFalse(productIterator.hasNext());
    }

    @Test
    void testEditOnlyProductName() {
        Product product = setProduct();

        Product updatedProduct = new Product();
        updatedProduct.setProductName("Sampo Cap Anto");
        updatedProduct.setProductQuantity(product.getProductQuantity());
        productRepository.edit(product.getProductId(), updatedProduct);

        Iterator<Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());
        Product savedProduct = productIterator.next();
        assertEquals("Sampo Cap Anto", savedProduct.getProductName());
        assertEquals(100, savedProduct.getProductQuantity());
    }

    @Test
    void testDeleteIfProductExists() {
        Product product = setProduct();
        productRepository.delete(product.getProductId());

        Iterator<Product> productIterator = productRepository.findAll();
        assertFalse(productIterator.hasNext());
    }

    @Test
    void testFoundProductByID() {
        Product product = setProduct();

        Product foundProduct = productRepository.findById("eb558e9f-1c39-460e-8860-71af6af63bd6");
        assertNotNull(foundProduct);
        assertEquals("eb558e9f-1c39-460e-8860-71af6af63bd6", foundProduct.getProductId());
        assertEquals("Sampo Cap Bambang", foundProduct.getProductName());
        assertEquals(100, foundProduct.getProductQuantity());
    }

    @Test
    void testNotFoundProductByID() {
        Product foundProduct = productRepository.findById("999");
        assertNull(foundProduct);
    }

    @Test
    void testNullProductID() {
        Product nullProduct = new Product();
        nullProduct.setProductId(null);
        productRepository.create(nullProduct);

        assertNull(productRepository.findById(null));
    }

    @Test
    void testEditProductIdShouldNotChange() {
        Product product = setProduct();

        Product updatedProduct = new Product();
        updatedProduct.setProductName("Sampo Cap Anto");
        updatedProduct.setProductQuantity(50);
        productRepository.edit(product.getProductId(), updatedProduct);

        Product foundProduct = productRepository.findById("eb558e9f-1c39-460e-8860-71af6af63bd6");
        assertNotNull(foundProduct);
        assertEquals("eb558e9f-1c39-460e-8860-71af6af63bd6", foundProduct.getProductId());
        assertEquals("Sampo Cap Anto", foundProduct.getProductName());
        assertEquals(50, foundProduct.getProductQuantity());
    }
}
