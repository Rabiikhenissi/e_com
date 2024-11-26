package org.example.Metier;

import org.example.Dao.CategorieDao;
import org.example.Entities.Categorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorieMetier {
    @Autowired
    private CategorieDao categorieRepository;

    public List<Categorie> getAllCategories() {
        return categorieRepository.findAll();
    }

    public Categorie getCategorieById(String id) {
        return categorieRepository.findById(id).orElse(null);
    }

    public Categorie addCategorie(Categorie categorie) {
        return categorieRepository.save(categorie);
    }

    public Categorie updateCategorie(String id, Categorie updatedCategorie) {
        return categorieRepository.findById(id).map(categorie -> {
            categorie.setName(updatedCategorie.getName());
            return categorieRepository.save(categorie);
        }).orElse(null);
    }

    public void deleteCategorie(String id) {
        categorieRepository.deleteById(id);
    }
}
