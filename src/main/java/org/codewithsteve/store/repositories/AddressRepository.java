package org.codewithsteve.store.repositories;

import org.codewithsteve.store.entities.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long> {
}