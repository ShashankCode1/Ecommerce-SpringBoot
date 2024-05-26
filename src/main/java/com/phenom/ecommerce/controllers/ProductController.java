package com.phenom.ecommerce.controllers;

import com.phenom.ecommerce.models.Product;
import com.phenom.ecommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

// Product controller class
@RequestMapping("/products")
@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    // Add product with image
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String addProduct(@RequestParam("prodName") String prodName,
                             @RequestParam("category") String category,
                             @RequestParam("description") String description,
                             @RequestParam("price") double price,
                             @RequestPart(value = "image", required = false) MultipartFile image) throws IOException {
        Product product = new Product();
        product.setProdName(prodName);
        product.setCategory(category);
        product.setDescription(description);
        product.setPrice(price);
        return productService.addProduct(product, image);
    }

    @DeleteMapping("/{prodId}")
    public String deleteProductById(@PathVariable String prodId) throws IOException {
        return productService.deleteProductById(prodId);
    }

    @GetMapping("/count")
    public int getProductsCount() {
        return productService.getProductsCount();
    }

}
