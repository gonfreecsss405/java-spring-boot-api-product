package com.example.demo;
import java.util.*;

public record ProductResponse(Long id , String name , double price , Set<CategoryResponse> categories) {
    
}
