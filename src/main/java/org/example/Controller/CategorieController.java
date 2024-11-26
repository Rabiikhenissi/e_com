package org.example.Controller;

import org.example.Entities.Categorie;
import org.example.Metier.CategorieMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategorieController {

    @Autowired
    private CategorieMetier categorieMetier;

    @GetMapping
    public List<Categorie> getAllCategories() {
        return categorieMetier.getAllCategories();
    }

    @GetMapping("/{id}")
    public Categorie getCategorieById(@PathVariable String id) {
        return categorieMetier.getCategorieById(id);
    }

    @PostMapping
    public Categorie addCategorie(@RequestBody Categorie categorie) {
        return categorieMetier.addCategorie(categorie);
    }

    @PutMapping("/{id}")
    public Categorie updateCategorie(@PathVariable String id, @RequestBody Categorie categorie) {
        return categorieMetier.updateCategorie(id, categorie);
    }

    @DeleteMapping("/{id}")
    public void deleteCategorie(@PathVariable String id) {
        categorieMetier.deleteCategorie(id);
    }
}
