package org.codewithsteve.store.repositories;

import org.codewithsteve.store.entities.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}