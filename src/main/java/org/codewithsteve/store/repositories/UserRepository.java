package org.codewithsteve.store.repositories;

import org.codewithsteve.store.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
