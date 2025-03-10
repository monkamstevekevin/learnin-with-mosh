package org.codewithsteve.store.repositories;

import org.codewithsteve.store.dto.UserSummary;
import org.codewithsteve.store.entities.Profile;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ProfileRepository extends CrudRepository<Profile, Long> {


}