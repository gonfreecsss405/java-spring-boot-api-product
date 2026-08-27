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
    private Set<Product> products;

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

    @Override
    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        if(o == null || getClass() != o.getClass()){
            return false;
        }
        Category category = (Category) o;
        return Objects.equals(id , category.id);
    }
    @Override
    public int hashCode(){
        return Objects.hash(id);
    }
}
