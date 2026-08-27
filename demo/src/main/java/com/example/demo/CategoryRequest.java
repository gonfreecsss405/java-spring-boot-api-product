package com.example.demo;

import jakarta.validation.constraints.NotBlank;

public record CategoryRequest(@NotBlank(message = "กรุณากรอกชื่อประเภทสินค้า") String name) {

}
