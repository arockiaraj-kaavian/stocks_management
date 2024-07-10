package com.example.stockmanage.dao;

// import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.stockmanage.model.Products;

public interface Stockrepository  extends MongoRepository<Products, Integer>{

}
