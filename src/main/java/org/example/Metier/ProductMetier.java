package org.example.Metier;

import org.example.Dao.ProductDao;
import org.example.Entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductMetier {
    @Autowired
    private ProductDao productRepository;

    @Autowired
    private CategorieMetier categorieMetier;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(String id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product addProduct(Product product) {
        if (categorieMetier.getCategorieById(product.getCategoryId()) == null) {
        }
        return productRepository.save(product);
    }

    public Product updateProduct(String id, Product updatedProduct) {
        return productRepository.findById(id).map(product -> {
            product.setName(updatedProduct.getName());
            product.setDescription(updatedProduct.getDescription());
            product.setPrice(updatedProduct.getPrice());
            product.setQuantity(updatedProduct.getQuantity());
            product.setImage(updatedProduct.getImage());
            product.setCategoryId(updatedProduct.getCategoryId());
            return productRepository.save(product);
        }).orElse(null);
    }

    public void deleteProduct(String id) {
        productRepository.deleteById(id);
    }
}
