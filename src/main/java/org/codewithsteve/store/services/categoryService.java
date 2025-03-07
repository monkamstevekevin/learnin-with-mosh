package org.codewithsteve.store.services;

import lombok.AllArgsConstructor;
import org.codewithsteve.store.entities.Category;
import org.codewithsteve.store.entities.Product;
import org.codewithsteve.store.repositories.CategoryRepository;
import org.codewithsteve.store.repositories.ProductRepository;
import org.codewithsteve.store.repositories.UserRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@AllArgsConstructor
@Component
public class categoryService {
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    private final UserRepository UserRepository;
    private final UserRepository userRepository;

    @Transactional
    public void showRelated(){
        var category = Category.builder().name("machinery").build();
         var product = Product.builder().name("leaning machinery").price(BigDecimal.valueOf(135.20)).build();
   category.addProduct(product);
        categoryRepository.save(category);

    }
    @Transactional
     public void createProductForCategory(){
    var category  =  categoryRepository.findById((byte) 1).orElseThrow();
     var product = Product.builder().name("washing machine1").price(BigDecimal.valueOf(13.20)).build();
     productRepository.save(product);
     category.addProduct(product);
     }
     @Transactional
     public void addProductToUserFavoriteProduct(){
    var user  = userRepository.findById(1L).orElseThrow();
    var products =  productRepository.findAll();
    for(Product product : products){
        user.addFavoriteProduct(product);
    }
    userRepository.save(user);
     }
    public void deletingProduct(){

        productRepository.deleteById(1L);
    }
}
