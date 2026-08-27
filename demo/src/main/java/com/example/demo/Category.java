package com.example.demo;

import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id" , nullable = false)
    private Long id;
    @Column(name = "category_name" , nullable = false)
    private String name;
    @ManyToMany(mappedBy = "categories")
    private Set<Product> products = new HashSet<>();

    public Category(){}

    public void setName(String name){
        this.name = name;
    }
    public void setProducts(Set<Product> products){
        this.products = products;
    }
    public Long getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public Set<Product> getProducts(){
        return this.products;
    }
}
