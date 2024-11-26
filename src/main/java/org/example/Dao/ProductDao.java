package org.example.Dao;

import org.example.Entities.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProductDao  extends MongoRepository<Product, String> {

    List<Product> findByCategoryId(String categoryId);
}