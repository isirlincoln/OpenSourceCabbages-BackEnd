package com.osc.product;
    

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    @Autowired
    ProductRepository dao;

    // READ
    @GetMapping("/product")
    public List<Product> getProducts() {
        List<Product> foundUsers = dao.findAll();
        return foundUsers;
    }

    // CREATE
    @PostMapping("/product")
    public ResponseEntity<Product> postProduct(@RequestBody Product product) {
        // This saves to the osc database using repository.
        Product createProduct = dao.save(product);
        // Gives a response to include our status code
        return ResponseEntity.ok(createProduct);
    }

    // UPDATE
    @PutMapping("/product/{id}")
    public ResponseEntity<Product> putUser(@PathVariable Integer id, @RequestBody Product product) {
        Product foundProduct = dao.findById(id).orElse(null);
        if (foundProduct == null) {
            return ResponseEntity.notFound().header("Message", "Product is not found").build();
        } else {
            if (product.getProductName() != null) {
                foundProduct.setProductName(product.getProductName());
            }
            if (product.getPrice() > 0) {
                foundProduct.setPrice(product.getPrice());
            }
            if (product.getDescription() != null) {
                foundProduct.setDescription(product.getDescription());
            }
            if (product.getImageUrl() != null) {
                foundProduct.setImageUrl(product.getImageUrl());
            }
            if (product.getInventory() >=0) {
                foundProduct.setInventory(product.getInventory());
            }
            dao.save(foundProduct);
        }

        return ResponseEntity.ok(foundProduct);
    }

    // DELETE
    @DeleteMapping("/product/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable(value = "id") Integer id) {
        Product foundProduct = dao.findById(id).orElse(null);
        if (foundProduct == null) {
            return ResponseEntity.notFound().header("Message", "Product is not found").build();
        } else {
            dao.delete(foundProduct);
        }
        return ResponseEntity.ok().build();
    }

}
