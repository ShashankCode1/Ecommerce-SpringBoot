package com.phenom.ecommerce.services;

import com.phenom.ecommerce.models.Product;
import com.phenom.ecommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

// Product service class
@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    // Path to store images
    @Value("${images.path}")
    private String imageDirectoryPath;

    // Get all products
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    // Add product with image
    public String addProduct(Product product, MultipartFile image) throws IOException {
        if (image != null && !image.isEmpty()) {
            String imageURL = createImageURL(image);    // imageUrl is the path where image is stored
            product.setImageURL(imageURL);
        }
        productRepository.save(product);
        return "Product added successfully";
    }

    // Create image URL
    private String createImageURL(MultipartFile image) throws IOException {
        Path directoryPath = Paths.get(imageDirectoryPath);    // Path to store images
        Files.createDirectories(directoryPath);         // Create directories if not exists

        String imageName = System.currentTimeMillis() + "-" + image.getOriginalFilename();
        Path imagePath = directoryPath.resolve(imageName);  // imagePath holds the complete path where image is stored

        // Copy image to the imagePath & replace if already exists
        Files.copy(image.getInputStream(), imagePath, StandardCopyOption.REPLACE_EXISTING);
        return imageName;
    }

    // Delete product by id
    public String deleteProductById(String prodId) throws IOException {
        Product prod = productRepository.findById(prodId).orElse(null);
        if (prod != null) {
            String imageURL = imageDirectoryPath + prod.getImageURL();
            if (imageURL != null && !imageURL.isBlank()) {
                Path imageFile = Paths.get(imageURL);   // imageFile holds the path where image is stored
                if (Files.exists(imageFile)) {          // Checks image if exists
                    Files.delete(imageFile);            // Delete image if exists
                }
            }
            productRepository.deleteById(prodId);
            return "Product is deleted";
        } else {
            return "Product Id " + prodId + " is not found";
        }
    }

    // Get products count
    public int getProductsCount() {
        return productRepository.findProductsCount();
    }
}
