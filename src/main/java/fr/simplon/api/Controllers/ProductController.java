package fr.simplon.api.Controllers;

import fr.simplon.api.Models.Product;
import fr.simplon.api.Repositoy.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/product/")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostMapping("/products")
    public Product createUser(@ModelAttribute ("name") String name,
                              @ModelAttribute ("price") Float price) {

        Product product = new Product();
        product.setName(name);
        product.setPrice(price);


        return  productRepository.save(product);
    }

    @GetMapping("/products")
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @GetMapping("/{productId}")
    public Optional<Product> getAllUsers(@PathVariable Integer productId) {
        return productRepository.findById(productId);
    }

}
