package com.example.demo;

import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.*;

@Service
public class StoreService {
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    public StoreService(CategoryRepository categoryRepository , ProductRepository productRepository){
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }
    private ProductResponse mapToProduct(Product product){
        Set<CategoryResponse> categoryResponses = product.getCategories().stream().map(c -> new CategoryResponse(c.getId() , c.getName())).collect(Collectors.toSet());
        return new ProductResponse(product.getId(), product.getName(), product.getPrice(), categoryResponses);
    }
    public CategoryResponse createCategory(CategoryRequest request){
        Category category = new Category();
        category.setName(request.name());
        Category saved = categoryRepository.save(category);
        return new CategoryResponse(saved.getId(), saved.getName());
    }
    public ProductResponse createProduct(ProductRequest request){
        Product product = new Product();
        product.setName(request.name());
        product.setPrice(request.price());
        Product saved = productRepository.save(product);
        return mapToProduct(saved);
    }
    public ProductResponse addCategoryToProduct(Long productId , Long categoryId){
        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> 
            new ResourceNotFoundException("ไม่พบประเภทสินค้าID: " + categoryId)
        );
        Product product = productRepository.findById(productId).orElseThrow(() -> 
            new ResourceNotFoundException("ไม่พบสินค้าID: " + productId)
        );
        product.getCategories().add(category);
        Product saved = productRepository.save(product);
        return mapToProduct(saved);
    }
    public ProductResponse removeCategoryToProduct(Long categoryId , Long productId){
        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> 
            new ResourceNotFoundException("ไม่พบประเภทสินค้าID: " + categoryId)
        );
        Product product = productRepository.findById(productId).orElseThrow(() -> 
            new ResourceNotFoundException("ไม่พบสินค้าID: " + productId)
        );
        product.getCategories().remove(category);
        Product remove = productRepository.save(product);
        return mapToProduct(remove);
    }
}
