package com.example.demo;

import jakarta.validation.constraints.NotBlank;

public record CategoryRequest(@NotBlank(message = "กรุณาชื่อประเภทสินค้า") String name) {
    
}
