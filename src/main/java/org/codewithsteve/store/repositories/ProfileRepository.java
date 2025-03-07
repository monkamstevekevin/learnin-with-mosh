package org.codewithsteve.store.repositories;

import org.codewithsteve.store.entities.Profile;
import org.springframework.data.repository.CrudRepository;

public interface ProfileRepository extends CrudRepository<Profile, Long> {

  }