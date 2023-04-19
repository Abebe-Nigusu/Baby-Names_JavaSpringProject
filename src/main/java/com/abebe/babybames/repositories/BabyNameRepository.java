package com.abebe.babybames.repositories;


import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.abebe.babybames.models.BabyName;

@Repository
public interface BabyNameRepository  extends CrudRepository<BabyName, Long>{
	List<BabyName> findAll();
	Optional<BabyName> findByName(String name);
}
