package org.codewithsteve.store.repositories;

import org.codewithsteve.store.entities.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Byte> {
}