package id.ac.ui.cs.advprog.eshop.controller;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/create")
    public String createProductPage(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "CreateProduct";
    }

    @PostMapping("/create")
    public String createProductPost(@ModelAttribute Product product, Model model) {
        service.create(product);
        return "redirect:list";
    }

    @GetMapping("/list")
    public String productListPage(Model model) {
        List<Product> allProducts = service.findAll();
        model.addAttribute("products", allProducts);
        return "ProductList";
    }

    @GetMapping("/edit/{productId}")
    public String editProductPage(@PathVariable("productId") String productId, Model model) {
        Product product = service.findById(productId);
        if (product == null) {
            return "redirect:/product/list";
        }
        model.addAttribute("product", product);
        return "EditProduct";
    }

    @PostMapping("/edit/{productId}")
    public String editProduct(@PathVariable("productId") String productId, @ModelAttribute Product product,
                              Model model) {
        product.setProductId(productId);
        service.edit(product.getProductId(), product);
        return "redirect:/product/list";
    }

    @GetMapping("/delete/{productId}")
    public String deleteProduct(@PathVariable("productId") String productId, Model model) {
        service.delete(productId);
        return "redirect:/product/list";
    }
}
