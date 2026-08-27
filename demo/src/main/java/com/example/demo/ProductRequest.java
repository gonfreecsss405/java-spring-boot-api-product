package com.example.demo;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record ProductRequest(@NotBlank(message = "กรุณากรอกชื่อสินค้า") String name , @Min(value = 0 , message = "ราคาสินค้าต้องไม่ติดลบ") double price) {
    
}
