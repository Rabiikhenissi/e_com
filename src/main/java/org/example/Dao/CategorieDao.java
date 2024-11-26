package org.example.Dao;

import org.example.Entities.Categorie;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategorieDao extends MongoRepository<Categorie, String> {
}
