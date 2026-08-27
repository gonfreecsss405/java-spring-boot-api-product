package com.example.demo;

import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id" , nullable = false)
    private Long id;
    @Column(name = "product_name" , nullable = false)
    private String name;
    @Column(name = "product_price" , nullable = false)
    private double price;
    @ManyToMany(cascade = {CascadeType.PERSIST , CascadeType.MERGE})
    @JoinTable(name = "product_category" , joinColumns = @JoinColumn(name = "category_id") , inverseJoinColumns = @JoinColumn(name = "product_id"))
    private Set<Category> categories = new HashSet<>();

    public Product(){}

    public void setName(String name){
        this.name = name;
    }
    public void setCategories(Set<Category> categories){
        this.categories = categories;
    }
    public void setPrice(double price){
        this.price = price;
    }
    public Long getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public double getPrice(){
        return this.price;
    }
    public Set<Category> getCategories(){
        return this.categories;
    }
}
