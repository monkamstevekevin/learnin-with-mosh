package org.codewithsteve.store.repositories;

import org.codewithsteve.store.entities.Category;
import org.codewithsteve.store.entities.Product;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {
    List<Product> findByCategory(Category category);
    @Query("select p from Product p where p.price between :min and :max order by p.name")
    List<Product> findByPriceBetweenOrderByName(@Param("min") BigDecimal min, @Param("max") BigDecimal max);
    @Query("select count(*) from Product p where p.price between :min and :max")
    long countProducts(@Param("min") BigDecimal min, @Param("max") BigDecimal max);
    @Modifying
     @Query("update Product p set p.price = :newPrice where p.category.id = : categoryId")
    void updatePriceByCategory(BigDecimal newPrice, Byte categoryId);

}