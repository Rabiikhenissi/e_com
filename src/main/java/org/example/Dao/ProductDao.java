package org.example.Dao;

import org.example.Entities.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductDao  extends MongoRepository<Product, String> {


}