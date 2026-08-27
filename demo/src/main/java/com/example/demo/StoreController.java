package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class StoreController {
    private final StoreService storeService;
    public StoreController(StoreService storeService){
        this.storeService = storeService;
    }
    @PostMapping("/categories")
    public ResponseEntity<CategoryResponse> createCategory(@Valid @RequestBody CategoryRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(storeService.createCategory(request));
    }
    @PostMapping("/products")
    public ResponseEntity<ProductResponse> createProduct(@Valid @RequestBody ProductRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(storeService.createProduct(request));
    }
    @PostMapping("/products/{productId}/categories/{categoryId}")
    public ResponseEntity<ProductResponse> addProductToCategory(@PathVariable Long productId ,@PathVariable Long categoryId){
        return ResponseEntity.ok(storeService.addCategoryToProduct(productId, categoryId));
    }
}
