package hu.elte.clothingwebshop.controllers;

import hu.elte.clothingwebshop.entities.Product;
import hu.elte.clothingwebshop.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("")
    public ResponseEntity<Iterable<Product>> getProducts() {
        Iterable<Product> products = productRepository.findAll();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable Integer productId) {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if(optionalProduct.isPresent()) {
            return ResponseEntity.ok(optionalProduct.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product saveProduct = productRepository.save(product);
        return ResponseEntity.ok(saveProduct);
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<Product> deleteProduct(@PathVariable Integer productId) {
        try {
            productRepository.deleteById(productId);
            return ResponseEntity.ok().build();
        } catch (EmptyResultDataAccessException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{productId}")
    public ResponseEntity<Product> modifyProduct(@RequestBody Product modifiedProduct, @PathVariable Integer productId) {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if(!optionalProduct.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        Product product = optionalProduct.get();
        if(modifiedProduct.getNetPrice() != null) {
            product.setNetPrice(modifiedProduct.getNetPrice());
        }
        if(modifiedProduct.getGrossPrice() != null) {
            product.setGrossPrice(modifiedProduct.getGrossPrice());
        }
        if(modifiedProduct.getDescription() != null) {
            product.setDescription(modifiedProduct.getDescription());
        }
        if(modifiedProduct.getStock() != null) {
            product.setStock(modifiedProduct.getStock());
        }
        Product savedProduct = productRepository.save(product);
        return ResponseEntity.ok(savedProduct);
    }

}
